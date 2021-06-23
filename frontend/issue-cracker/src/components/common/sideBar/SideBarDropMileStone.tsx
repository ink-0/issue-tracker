import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import CheckOnIcon from '../../styles/svg/CheckOnIcon';
import CheckOffIcon from '../../styles/svg/CheckOffIcon';
import { Text as S } from '../../styles/CommonStyles';
import { useRecoilState } from 'recoil';
import { dropCheckState } from '../../../store/Recoil';

interface SideBarDropMilestoneProps {
  data: {
    id: number;
    title: string;
    description: string;
    due_date: string;
  };
}
const SideBarDropMilestone = ({
  data,
}: SideBarDropMilestoneProps): JSX.Element => {
  const [isCheck, setIsCheck] = useState(false);
  const [dropCheck, setDropCheck] = useRecoilState(dropCheckState);

  const handleClickMilestone = () => {
    setIsCheck(!isCheck);

    if (!isCheck) {
      setDropCheck({
        ...dropCheck,
        milestone: [...dropCheck.milestone, data.id],
      });
    } else {
      setDropCheck({
        ...dropCheck,
        milestone: dropCheck.milestone.filter((el) => el !== data.id),
      });
    }
  };

  useEffect(() => {
    if (dropCheck.milestone.includes(data.id)) {
      setIsCheck(true);
    }
  }, []);

  return (
    <SideBarDropMileStoneStyle onClick={handleClickMilestone}>
      <DropLeft>
        <MileStoneName>{data.title}</MileStoneName>
      </DropLeft>
      <DropRight>{isCheck ? <CheckOnIcon /> : <CheckOffIcon />}</DropRight>
    </SideBarDropMileStoneStyle>
  );
};

export default SideBarDropMilestone;

const SideBarDropMileStoneStyle = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
`;
const MileStoneName = styled(S.TextSmall)`
  margin-left: 8px;
`;
const DropLeft = styled.div`
  display: flex;
`;
const DropRight = styled.div`
  display: flex;
  align-items: center;
`;

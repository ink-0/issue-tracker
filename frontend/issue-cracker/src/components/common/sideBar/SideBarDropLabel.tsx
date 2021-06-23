import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import { Text as S } from '../../styles/CommonStyles';
import { useRecoilState } from 'recoil';
import { dropCheckState } from '../../../store/Recoil';
import CheckOffIcon from '../../styles/svg/CheckOffIcon';
import LabelColorIcon from '../../styles/svg/LabelColorIcon';
import CheckOnIcon from '../../styles/svg/CheckOnIcon';

interface SideBarDropLabelProps {
  data: {
    id: number;
    title: string;
    description: string;
    background_color_hexa: string;
    text_color_hexa: string;
  };
}

const SideBarDropLabel = ({ data }: SideBarDropLabelProps): JSX.Element => {
  const [isCheck, setIsCheck] = useState(false);
  const [dropCheck, setDropCheck] = useRecoilState(dropCheckState);

  const handleClickLabel = () => {
    setIsCheck(!isCheck);

    if (!isCheck) {
      setDropCheck({
        ...dropCheck,
        label: [...dropCheck.label, data.id],
      });
    } else {
      setDropCheck({
        ...dropCheck,
        label: dropCheck.label.filter((el) => el !== data.id),
      });
    }
  };

  useEffect(() => {
    if (dropCheck.label.includes(data.id)) {
      setIsCheck(true);
    }
  }, []);

  return (
    <SideBarDropLabelStyle onClick={() => handleClickLabel()}>
      <DropLeft>
        <LabelColorIcon color="#DDA94B" />
        <LabelName>{data.title}</LabelName>
      </DropLeft>
      <DropRight>{isCheck ? <CheckOnIcon /> : <CheckOffIcon />}</DropRight>
    </SideBarDropLabelStyle>
  );
};

export default SideBarDropLabel;

const SideBarDropLabelStyle = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
  align-items: center;
`;
const LabelName = styled(S.TextSmall)`
  margin-left: 8px;
`;
const DropLeft = styled.div`
  display: flex;
`;
const DropRight = styled.div``;

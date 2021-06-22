import React, { useState } from 'react';
import styled from 'styled-components';
import { ProfileImg as S, Text as T } from '../../styles/CommonStyles';
import { useRecoilValue } from 'recoil';
import { decodedToken } from '../../../store/Recoil';
import CheckOffIcon from '../../styles/svg/CheckOffIcon';
import CheckOnIcon from '../../styles/svg/CheckOnIcon';

interface SideBarDropAssigneeProps {
  data: {
    id: string;
    name: string;
    profile_image_url: string;
    emails: string[];
  };
}

const SideBarDropAssignee = ({
  data,
}: SideBarDropAssigneeProps): JSX.Element => {
  const decoded = decodedToken && useRecoilValue(decodedToken);
  const profileURL = decoded && decoded.profileImageUrl;
  const [isCheck, setIsCheck] = useState(false);
  // const profileName = decoded && decoded.name;
  const handleClickAssignee = () => {
    setIsCheck(!isCheck);
  };
  return (
    <SideBarDropAssigneeStyle
      onClick={() => {
        handleClickAssignee();
      }}
    >
      <DropLeft>
        <S.ProfileImgSmall src={profileURL}></S.ProfileImgSmall>
        <ProfileName>{data.name}</ProfileName>
      </DropLeft>
      <DropRight>{isCheck ? <CheckOnIcon /> : <CheckOffIcon />}</DropRight>
    </SideBarDropAssigneeStyle>
  );
};
export default SideBarDropAssignee;

const SideBarDropAssigneeStyle = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  cursor: pointer;
`;
const ProfileName = styled(T.TextSmall)`
  margin-left: 8px;
`;
const DropLeft = styled.div`
  display: flex;
  align-items: center;
`;
const DropRight = styled.div``;

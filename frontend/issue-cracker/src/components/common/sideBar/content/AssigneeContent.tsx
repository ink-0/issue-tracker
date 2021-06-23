import React from 'react';
import styled from 'styled-components';
import { ProfileImg as P } from '../../../styles/CommonStyles';
import { v4 as uuidv4 } from 'uuid';
import { useRecoilValue } from 'recoil';
import { issueForm } from '../../../../store/Recoil';
import { AssigneeDataProps } from '../../../../utils/types/sideBarType';

const AssigneeContent = ({ userList }: AssigneeDataProps): JSX.Element => {
  const dropTotalState = useRecoilValue(issueForm);

  console.log('어사이니컨텐트안 데이터', dropTotalState);
  return (
    <>
      {userList?.map((assignee) => (
        <div key={uuidv4()}>
          <P.ProfileImgLarge src={assignee.profile_image_url} />
          <AccountName>{assignee.name}</AccountName>
        </div>
      ))}
    </>
  );
};

export default AssigneeContent;

const AccountName = styled.div`
  margin: 4px 4px;
  color: ${({ theme }) => theme.colors.gray2};
  font-family: 'Montserrat', sans-serif;
`;

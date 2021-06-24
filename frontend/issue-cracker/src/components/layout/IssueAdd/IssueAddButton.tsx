import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import TextGroup from '../../common/group/TextGroup';
import ButtonGroup from '../../common/group/ButtonGroup';
import CloseIcon from '@material-ui/icons/Close';
import {
  BUTTON_SIZE as BS,
  TYPE as T,
  PATH as P,
  BUTTON_NAME as BN,
  URL as U,
} from '../../../utils/const';
import { issueAddData, token } from '../../../store/Recoil';
import { useRecoilValue } from 'recoil';

const IssueAddButton = (): JSX.Element => {
  const issueAdd = useRecoilValue(issueAddData);
  // const userToken = useRecoilValue(token);
  const userToken = localStorage.getItem('token');

  const handleClickCompleteButton = async () => {
    return await fetch(U.ISSUES, {
      method: 'POST',
      body: JSON.stringify(issueAdd),
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${userToken}`,
      },
    })
      .then((res) => res.json())
      .then((response) => console.log('Success:', JSON.stringify(response)))
      .catch((error) => console.error('Error:', error));
  };
  return (
    <IssueAddButtonStyle>
      <Link to={P.ISSUE_LIST}>
        <CancelButton>
          <WriteCancelButton />
          <TextGroup
            type={T.SMALL}
            content={BN.WRITING_CANCEL}
            color="#6E7191"
          />
        </CancelButton>
      </Link>
      <ButtonGroup
        type={BS.MEDIUM}
        name={BN.COMPLETE}
        onClick={handleClickCompleteButton}
        color="#fff"
      />
    </IssueAddButtonStyle>
  );
};

export default IssueAddButton;

const IssueAddButtonStyle = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
`;

const CancelButton = styled.button`
  display: flex;
  align-items: center;
  background: none;
  padding: 10px 20px;
  margin: 10px;
  cursor: pointer;
`;

const WriteCancelButton = styled(CloseIcon)`
  color: #6e7191;
  font-size: 12px;
  margin: 3px;
`;

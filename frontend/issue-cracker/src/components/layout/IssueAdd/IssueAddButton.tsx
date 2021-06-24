import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import TextGroup from '../../common/group/TextGroup';
import ButtonGroup from '../../common/group/ButtonGroup';
import CloseIcon from '@material-ui/icons/Close';
import { BUTTON_SIZE as BS, TYPE as T, PATH as P } from '../../../utils/const';

const IssueAddButton = (): JSX.Element => {
  return (
    <IssueAddButtonStyle>
      <Link to={P.ISSUE_LIST}>
        <CancelButton>
          <WriteCancelButton />
          <TextGroup type={T.SMALL} content="작성 취소" color="#6E7191" />
        </CancelButton>
      </Link>
      <ButtonGroup type={BS.MEDIUM} name="완료" color="#fff" />
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

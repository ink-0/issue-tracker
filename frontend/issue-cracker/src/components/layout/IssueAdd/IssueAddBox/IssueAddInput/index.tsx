import React from 'react';
import { useRecoilValue, useRecoilState } from 'recoil';
import styled from 'styled-components';
import { issueAddData, dropCheckState } from '../../../../../store/Recoil';
import IssueAddInputContent from './IssueAddInputContent';
import IssueAddInputTitle from './IssueAddInputTitle';

const IssueAddInput = (): JSX.Element => {
  return (
    <IssueAddInputStyle>
      <IssueAddInputTitle />
      <IssueAddInputContent />
    </IssueAddInputStyle>
  );
};

export default IssueAddInput;

const IssueAddInputStyle = styled.div`
  display: flex;
  flex-direction: column;
  padding: 10px;
  width: 100%;
`;

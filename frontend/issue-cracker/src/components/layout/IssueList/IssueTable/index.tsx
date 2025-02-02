import React from 'react';
import styled from 'styled-components';
import { useRecoilValue } from 'recoil';
import { issueListData } from '../../../../store/Recoil';
import IssueTableHeader from './IssueTableHeader';
import IssueCell from './IssueCell';

const IssueTable = (): JSX.Element => {
  const issueData = useRecoilValue(issueListData);
  const issues = issueData.issues;

  return (
    <IssueTableContainer>
      <IssueTableHeader {...{ issues }} />
      <IssueCell {...{ issues }} />
    </IssueTableContainer>
  );
};

export default IssueTable;

const IssueTableContainer = styled.div``;

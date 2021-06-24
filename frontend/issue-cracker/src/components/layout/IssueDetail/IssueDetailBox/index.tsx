import React from 'react';
import styled from 'styled-components';
import IssueDetailInput from './IssueDetailInput';
import IssueDetailSidebar from './IssueDetailSidebar';
import { IssueDataProps } from '../../../../utils/types/IssueDataType';

const IssueDetailBox = ({ state }: { state: IssueDataProps }): JSX.Element => {
  return (
    <IssueDetailBoxStyle>
      <IssueDetailInput {...{ state }} />
      <React.Suspense fallback={null}>
        <IssueDetailSidebar {...{ state }} />
      </React.Suspense>
    </IssueDetailBoxStyle>
  );
};

export default IssueDetailBox;

const IssueDetailBoxStyle = styled.div`
  display: flex;
`;

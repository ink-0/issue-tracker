import React from 'react';
import { v4 as uuidv4 } from 'uuid';
import { useRecoilValue } from 'recoil';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import {
  Issue as S,
  Text as T,
  ProfileImg as P,
} from '../../../styles/CommonStyles';
import CheckBoxes from '../../../common/CheckBoxes';
import IssueOpenIcon from '../../../styles/svg/IssueOpenIcon';
import LabelSmallGroup from '../../../common/group/LabelSmallGroup';
import { decodedToken } from '../../../../store/Recoil';
import { IssueDataProps } from '../../../../utils/types/IssueDataType';
import { getElapsedTime, getIssue } from '../../../../utils/util';

const IssueCell = ({ issues }: { issues: IssueDataProps[] }): JSX.Element => {
  const decoded = decodedToken && useRecoilValue(decodedToken);
  const profileURL = decoded && decoded.profileImageUrl;

  const openIssue = getIssue(issues, 'OPEN');
  const closedIssue = getIssue(issues, 'CLOSED');

  return (
    <>
      {openIssue.map((issue) => {
        const {
          assignees,
          content,
          createdDateTime,
          issueId,
          labels,
          milestoneInfo,
          status,
          title,
          writer,
        } = issue;
        const elapsedTime = getElapsedTime(createdDateTime);

        return (
          <S.IssueCell key={uuidv4()}>
            <>
              <LeftBox>
                <CheckBoxes />
                <IssueCellContent>
                  <Link
                    to={{
                      pathname: `/main/issue-detail/${issueId}`,
                      state: {
                        issueId: issueId,
                        title: title,
                        content: content,
                        isOpen: status,
                        writer: writer.id,
                        elapsedTime: elapsedTime,
                        assignees: assignees,
                      },
                    }}
                  >
                    <IssueUpper>
                      <IssueOpenIcon
                        color="#3f51b5"
                        style={{ width: 24, height: 24 }}
                      />
                      <IssueTitle>{title}</IssueTitle>
                      {labels.map((label) => {
                        const { textColorHexa, backgroundColorHexa, title } =
                          label;

                        return (
                          <LabelSmallGroup
                            color={textColorHexa}
                            backgroundColor={backgroundColorHexa}
                            label={title}
                            key={uuidv4()}
                          />
                        );
                      })}
                    </IssueUpper>
                  </Link>
                  <T.TextSmall color="#6E7191">
                    <IssueLower>
                      <IssueID>#{issueId}</IssueID>
                      <IssueContent>
                        이 이슈가 {elapsedTime}, ink-0님에 의해 작성되었습니다.
                      </IssueContent>
                      <IssueMileStone>{milestoneInfo.title}</IssueMileStone>
                    </IssueLower>
                  </T.TextSmall>
                </IssueCellContent>
              </LeftBox>
              <RightBox>
                {assignees.map((assignee) => {
                  return (
                    <P.ProfileImgSmall
                      src={assignee.profileImageUrl}
                      key={uuidv4()}
                    />
                  );
                })}
              </RightBox>
            </>
          </S.IssueCell>
        );
      })}
    </>
  );
};

export default IssueCell;

const LeftBox = styled.div`
  display: flex;
`;
const RightBox = styled.div`
  display: flex;
  align-items: center;
  margin-right: 40px;
`;
const IssueCellContent = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;

  a {
    text-decoration: none;
    color: inherit;
  }
`;
const IssueUpper = styled.div`
  display: flex;
  align-items: center;
`;
const IssueLower = styled.div`
  display: flex;
`;
const IssueID = styled.div``;
const IssueContent = styled.div`
  margin: 0 16px;
`;
const IssueMileStone = styled.div``;
const IssueTitle = styled.div`
  font-weight: 600;
  margin: 0 9px;
`;

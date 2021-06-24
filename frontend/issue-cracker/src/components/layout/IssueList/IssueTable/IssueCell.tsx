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

const IssueCell = ({ issues }: { issues: IssueDataProps[] }): JSX.Element => {
  const decoded = decodedToken && useRecoilValue(decodedToken);
  const profileURL = decoded && decoded.profileImageUrl;

  const getIssue = (list: IssueDataProps[], str: string): IssueDataProps[] =>
    list.filter((el) => el.status === str);

  const getElapsedTime = (date: string): string => {
    const createdTime = new Date(2021, 5, 24, 4, 13, 0);
    const current = new Date();
    const gapMin = Math.floor((+current - +createdTime) / 1000 / 60);

    if (gapMin < 1) return '방금 전';

    if (gapMin < 60) return `${gapMin}분 전`;

    const gapHour = Math.floor(gapMin / 60);
    if (gapHour < 24) return `${gapHour}시간 전`;

    const gapDay = Math.floor(gapHour / 24);
    if (gapDay < 30) return `${gapDay}일 전`;

    const gapMonth = Math.floor(gapDay / 12);
    if (gapMonth < 12) return `${gapMonth}달 전`;

    return '몇 년 전';
  };

  const openIssue = getIssue(issues, 'OPEN');
  const closedIssue = getIssue(issues, 'CLOSED');
  console.log(issues);
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
        console.log(assignees);
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

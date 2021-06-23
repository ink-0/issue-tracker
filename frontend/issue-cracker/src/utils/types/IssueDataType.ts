import { AssigneeProps, LabelProps } from './sideBarType';

export interface IssueDataProps {
  issueId: number;
  milestoneInfo: {
    description: string;
    dueDate: string;
    title: string;
  };
  title: string;
  content: string;
  status: string;
  writer: AssigneeProps[];
  createdDateTime: string;
  assignees: AssigneeProps[];
  labels: LabelProps[];
}

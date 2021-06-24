export interface AssigneeProps {
  id: string | null;
  name: string | null;
  profileImageUrl: string;
  emails: string[] | null;
}

export interface LabelProps {
  id: number;
  title: string;
  description: string;
  backgroundColorHexa: string;
  textColorHexa: string;
}
export interface MilestoneProps {
  id: number;
  title: string;
  description: string;
  due_date: string;
}

export interface AssigneeDataProps {
  checkedAssignee?: AssigneeProps[];
  userData?: AssigneeProps[];
}
export interface LabelDataProps {
  checkedLabel?: LabelProps[];
  labelData?: LabelProps[];
}

export interface MilestoneDataProps {
  checkedMilestone?: MilestoneProps[];
  milestoneData?: MilestoneProps[];
}

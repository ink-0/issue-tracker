export interface AssigneeProps {
  id: string;
  name: string;
  profile_image_url: string;
  emails: string[];
}

export interface LabelProps {
  id: number;
  title: string;
  description: string;
  background_color_hexa: string;
  text_color_hexa: string;
}
export interface MilestoneProps {
  id: number;
  title: string;
  description: string;
  due_date: string;
}

export interface AssigneeDataProps {
  userList: AssigneeProps[];
}
export interface LabelDataProps {
  labelList: LabelProps[];
}

export interface MilestoneDataProps {
  milestoneList: MilestoneProps[];
}

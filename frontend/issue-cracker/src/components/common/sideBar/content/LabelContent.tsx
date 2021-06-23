import React from 'react';
import { v4 as uuidv4 } from 'uuid';

import LabelSmallGroup from '../../group/LabelSmallGroup';
import { LabelDataProps } from '../../../../utils/types/sideBarType';

const LabelContent = ({ labelList }: LabelDataProps): JSX.Element => {
  return (
    <>
      {labelList?.map((label) => (
        <LabelSmallGroup
          key={uuidv4()}
          color={label.text_color_hexa}
          backgroundColor={label.background_color_hexa}
          label={label.title}
        />
      ))}
    </>
  );
};

export default LabelContent;

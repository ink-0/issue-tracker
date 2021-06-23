INSERT INTO `pyrodb`.`user`(id, `name`, profileImageUrl)
VALUES ('san', '노을',
        'http://postfiles16.naver.net/20140606_111/sjinwon2_1402052862659ofnU1_PNG/130917_224626.png?type=w1'),
       ('pyro', '파이로',
        'http://postfiles16.naver.net/20140606_111/sjinwon2_1402052862659ofnU1_PNG/130917_224626.png?type=w1'),
       ('neo', '네오',
        'http://postfiles16.naver.net/20140606_111/sjinwon2_1402052862659ofnU1_PNG/130917_224626.png?type=w1'),
       ('tami', '타미',
        'http://postfiles16.naver.net/20140606_111/sjinwon2_1402052862659ofnU1_PNG/130917_224626.png?type=w1'),
       ('racoon', '라쿤',
        'http://postfiles16.naver.net/20140606_111/sjinwon2_1402052862659ofnU1_PNG/130917_224626.png?type=w1');

INSERT INTO `pyrodb`.`email`(email, userId)
VALUES ('68936@naver.com', 'san'),
       ('pyro@codesquad.com', 'pyro'),
       ('neo@codesquad.com', 'neo'),
       ('tami@codesquad.com', 'tami'),
       ('racoon@codesquad.com', 'racoon');

INSERT INTO `pyrodb`.`status` (`id`)
VALUES ('OPEN'),
       ('CLOSE'),
       ('ALL');

INSERT INTO `pyrodb`.`milestone`(title, description, dueDate)
VALUES ('마일스톤1', '마일스톤1 설명', NOW()),
       ('마일스톤2', '마일스톤2 설명', NOW());

INSERT INTO `pyrodb`.`issue`(title, content, writerId, statusId)
VALUES ('이슈제목1', '이슈내용1', 'san', 'OPEN'),
       ('이슈제목2', '이슈내용2', 'san', 'OPEN');

INSERT INTO `pyrodb`.`issue`(title, content, writerId, statusId, milestoneId)
VALUES ('이슈제목3-마일스톤1', '이슈내용1', 'san', 'OPEN', 1),
       ('이슈제목4-마일스톤1', '이슈내용2', 'san', 'OPEN', 1);

INSERT INTO `pyrodb`.`comment`(content, dateTime, writerId, issueId)
VALUES ('아슈 아이디1의 댓글 내용1', NOW(), 'san', 1),
       ('아슈 아이디1의 댓글 내용2', NOW(), 'pyro', 1),
       ('아슈 아이디1의 댓글 내용3', NOW(), 'neo', 1),
       ('아슈 아이디1의 댓글 내용4', NOW(), 'san', 1),

       ('이슈 아이디2의 댓글 내용2', NOW(), 'neo', 2),
       ('이슈 아이디3의 댓글 내용3', NOW(), 'tami', 3);

INSERT INTO `pyrodb`.`label`(title, description, backgroundColor, textColor)
VALUES ('라벨1 제목', '라벨1 설명', '#FFFFF', '#FFFFF'),
       ('라벨2 제목', '라벨2 설명', '#FFFFF', '#FFFFF');

INSERT INTO `pyrodb`.`issueLabel`(issueId, labelId)
VALUES (1, 1);

-- User table
CREATE TABLE `user` (
                        `userOriginCode` INT AUTO_INCREMENT PRIMARY KEY,
                        `username` VARCHAR(255) NOT NULL,
                        `email` VARCHAR(255) NOT NULL
    -- createDate와 modifiedDate는 JPA에서 자동 관리됨
);

-- Schedule table
CREATE TABLE `schedule` (
                            `scheduleId` INT AUTO_INCREMENT PRIMARY KEY,
                            `userOriginCode` INT,
                            `scheduleTitle` VARCHAR(255) NOT NULL,
                            `scheduleContent` TEXT,
                            FOREIGN KEY (`userOriginCode`) REFERENCES `user`(`userOriginCode`)
    -- createDate와 modifiedDate는 JPA에서 자동 관리됨
);

-- Comment table
CREATE TABLE `comment` (
                           `commentId` INT AUTO_INCREMENT PRIMARY KEY,
                           `scheduleId` INT,
                           `userOriginCode` INT,
                           `commentContent` TEXT NOT NULL,
                           FOREIGN KEY (`scheduleId`) REFERENCES `schedule`(`scheduleId`),
                           FOREIGN KEY (`userOriginCode`) REFERENCES `user`(`userOriginCode`)
    -- createDate와 modifiedDate는 JPA에서 자동 관리됨
);
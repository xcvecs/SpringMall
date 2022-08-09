-- Active: 1658224408952@@127.0.0.1@3306@test

--======================================================

-- 1  查询" 01 "课程比" 02 "课程成绩高的学生的信息及课程分数

select *
from Student
    RIGHT JOIN (
        select
            t1.SId,
            class1,
            class2
        from (
                select
                    SId,
                    score as class1
                from sc
                where
                    sc.CId = '01'
            ) as t1, (
                select
                    SId,
                    score as class2
                from sc
                where
                    sc.CId = '02'
            ) as t2
        where
            t1.SId = t2.SId
            AND t1.class1 > t2.class2
    ) r on Student.SId = r.SId;

SELECT * from sc;

select * from sc WHERE CId = 01;

select * from sc WHERE CId = 02;

select S1Id
from (
        select
            Sid S1ID,
            score score01
        from sc
        WHERE CId = 01
    ) sc1
    JOIN (
        select
            SId s2id,
            score score02
        from sc
        WHERE
            CId = 02
    ) sc2 ON score01 > score02
    AND S1Id = S2id;

SELECT *
from student
WHERE SId in (
        select S1Id
        from (
                select
                    Sid S1ID,
                    score score01
                from sc
                WHERE
                    CId = 01
            ) sc1
            JOIN (
                select
                    SId s2id,
                    score score02
                from sc
                WHERE
                    CId = 02
            ) sc2 ON score01 > score02
            AND S1Id = S2id
    );

SELECT *
from sc
WHERE SId in (
        select S1Id as SId
        from (
                select
                    Sid S1ID,
                    score score01
                from sc
                WHERE
                    CId = 01
            ) sc1
            JOIN (
                select
                    SId s2id,
                    score score02
                from sc
                WHERE
                    CId = 02
            ) sc2 ON score01 > score02
            AND S1Id = S2id
    );

---- end  question 1 : answer

select *
from student
    JOIN sc ON student.SId = sc.SId
WHERE sc.SId in (
        select S1Id as SId
        from (
                select
                    Sid S1ID,
                    score score01
                from sc
                WHERE
                    CId = 01
            ) sc1
            JOIN (
                select
                    SId s2id,
                    score score02
                from sc
                WHERE
                    CId = 02
            ) sc2 ON score01 > score02
            AND S1Id = S2id
    );

-- ===========================================

-- 1.1 查询同时存在" 01 "课程和" 02 "课程的情况

-- inner JOIN

select distinct S1Id, S2Id
from (
        select
            Sid S1ID,
            score score01
        from sc
        WHERE CId = 01
    ) sc1
    inner JOIN (
        select
            SId s2id,
            score score02
        from sc
        WHERE
            CId = 02
    ) sc2 ON S1Id = S2Id;

-- ===========================================

-- 1.2 查询存在" 01 "课程但可能不存在" 02 "课程的情况(不存在时显示为 null )

select distinct S1Id, S2Id
from (
        select
            Sid S1ID,
            score score01
        from sc
        WHERE CId = 01
    ) sc1
    LEFT JOIN (
        select
            SId s2id,
            score score02
        from sc
        WHERE
            CId = 02
    ) sc2 ON S1Id = S2Id;

-- ===========================================

-- 1.3 查询不存在" 01 "课程但存在" 02 "课程的情况

select *
from sc
where sc.SId not in (
        select SId
        from sc
        where
            sc.CId = '01'
    )
    AND sc.CId = '02';

SELECT S2ID
FROM (
        select
            distinct S1Id,
            S2Id
        from (
                select
                    Sid S1ID,
                    score score01
                from sc
                WHERE
                    CId = 01
            ) sc1
            RIGHT JOIN (
                select
                    SId s2id,
                    score score02
                from sc
                WHERE
                    CId = 02
            ) sc2 ON S1Id = S2Id
    ) as sidTable
WHERE S1Id is NULL;

-- ===========================================

-- 2 查询平均成绩大于等于 60 分的同学的学生编号和学生姓名和平均成绩

-- sum(), avg(),round()

select student.SId, sname, ss
from student, (
        select
            SId,
            AVG(score) as ss
        from sc
        GROUP BY SId
        HAVING
            AVG(score) > 60
    ) r
where student.sid = r.sid;

SELECT
    SId,
    round(avg(score)) as avgscore
FROM sc
GROUP BY Sid
HAVING avgscore > 60;

select Sid
from (
        SELECT
            SId,
            round(avg(score)) as avgscore
        FROM sc
        GROUP BY Sid
        HAVING
            avgscore > 60
    ) as a;

SELECT Sid, Sname, avgScore
from student
    JOIN (
        SELECT
            SId as avgSid,
            round(avg(score)) as avgscore
        FROM sc
        GROUP BY Sid
        HAVING
            avgscore > 60
    ) as a on SId = avgSid;

--================================================

-- 3 查询在 SC 表存在成绩的学生信息

select * from student WHERE sid in ( select distinct sid from sc );

-- =====================================================

-- 4 查询所有同学的学生编号、学生姓名、选课总数、所有课程的总成绩(没成绩的显示为 null )

select
    student.sid,
    student.sname,
    r.coursenumber,
    r.scoresum
from student, (
        select
            sc.sid,
            sum(sc.score) as scoresum,
            count(sc.cid) as coursenumber
        from sc
        group by sc.sid
    ) r
where student.sid = r.sid;

SELECT distinct sid, COUNT(cid) from sc GROUP BY sid;

SELECT *
FROM student as s
    left JOIN (
        SELECT
            distinct sid as asid,
            COUNT(cid),
            SUM(score)
        from sc
        GROUP BY
            sid
    ) AS sct on Sid = asid;

-- ==============================================================================

-- 4.1 查有成绩的学生信息

-- 结论：IN()适合B表比A表数据小的情况

-- 结论：EXISTS()适合B表比A表数据大的情况

select *
from student
where exists (
        select sc.sid
        from sc
        where
            student.sid = sc.sid
    );

select * from student where student.sid in (select sc.sid from sc);

SELECT *
FROM student as s
    JOIN (
        SELECT
            distinct sid as asid,
            COUNT(cid),
            SUM(score)
        from sc
        GROUP BY
            sid
    ) AS sct on Sid = asid;

-- ================================

-- 5 查询「李」姓老师的数量

select count(tname) from teacher WHERE tname LIKE '李%';

-- ================================================

-- 6 查询学过「张三」老师授课的同学的信息

SELECT * from teacher;

SELECT cid
from course
WHERE tid in (
        SELECT tid
        from teacher
        WHERE tname = '张三'
    );

select Sid
from sc
WHERE CId in (
        SELECT cid
        from course
        WHERE tid in (
                SELECT tid
                from teacher
                WHERE
                    tname = '张三'
            )
    );

select *
from student
WHERE sid in(
        select Sid
        from sc
        WHERE CId in (
                SELECT cid
                from course
                WHERE tid in (
                        SELECT
                            tid
                        from
                            teacher
                        WHERE
                            tname = '张三'
                    )
            )
    );

-- ============================================

-- 7 查询没有学全所有课程的同学的信息

select *
from student
where student.sid not in (
        select sc.sid
        from sc
        group by sc.sid
        having
            count(sc.cid) = (
                select
                    count(cid)
                from course
            )
    );

select
    sid,
    count(score) as counts
from sc
GROUP BY sid
HAVING counts = 3;

SELECT *
FROM student
WHERE student.sid not in (
        SELECT sid
        FROM (
                select
                    sid,
                    count(score) as counts
                from sc
                GROUP BY sid
                HAVING
                    counts = 3
            ) a
    );

-- ======================================================

-- 8 查询至少有一门课与学号为" 01 "的同学所学相同的同学的信息

select *
from student
where student.sid in (
        select sc.sid
        from sc
        where sc.cid in(
                select sc.cid
                from sc
                where
                    sc.sid = '01'
            )
    );

select cid from sc where sid=01;

select distinct sid
from sc
where cid in (
        select cid
        from sc
        where sid = 01
    );

-- ==========================================================

-- 9 查询和"01"号的同学学习的课程 完全相同的其他同学的信息

select cid from sc where sid=01;

select sid, count(cid) c from sc GROUP BY sid HAVING c>=3;

select count(cid) from sc where sid=01;

select sid
from (
        select
            sid,
            count(cid) c
        from sc
        GROUP BY sid
    ) a
    join (
        select count(cid) c
        from sc
        where
            sid = 01
    ) b on a.c = b.c;

--------------------------------------

select sid, COUNT(sid) counts
from sc
where sid = 5 and cid in (
        select cid
        from sc
        where sid = 6
    );

select sid, COUNT(sid) countsb
from sc
where sid = 6 and cid in (
        select cid
        from sc
        where sid = 5
    );

select sid
from (
        select
            sid,
            count(cid) c
        from sc
        GROUP BY sid
    ) a
    join (
        select count(cid) c
        from sc
        where
            sid = 6
    ) b on a.c = b.c;

select sid, COUNT(sid) counts
from sc
where sid in (
        select sid
        from (
                select
                    sid,
                    count(cid) c
                from sc
                GROUP BY
                    sid
            ) a
            join (
                select
                    count(cid) c
                from sc
                where
                    sid = 6
            ) b on a.c = b.c
    )
    and cid in (
        select cid
        from sc
        where sid = 06
    )
GROUP BY sid;

select sid
from (
        select
            sid,
            COUNT(sid) counts
        from sc
        where sid in (
                select sid
                from (
                        select
                            sid,
                            count(cid) c
                        from
                            sc
                        GROUP BY
                            sid
                    ) a
                    join (
                        select
                            count(cid) c
                        from
                            sc
                        where
                            sid = 1
                    ) b on a.c = b.c
            )
            and cid in (
                select cid
                from sc
                where sid = 1
            )
        GROUP BY sid
    ) a
    join (
        select
            count(cid) countbase
        from sc
        where sid = 1
    ) b
WHERE counts = countbase;

-- =========================================================

-- 10 查询没学过"张三"老师讲授的任一门课程的学生姓名

select *
from student
where student.sid not in(
        select sc.sid
        from sc
        where sc.cid in(
                select
                    course.cid
                from course
                where
                    course.tid in(
                        select
                            teacher.tid
                        from
                            teacher
                        where
                            tname = "张三"
                    )
            )
    );

select *
from student
where student.sid not in(
        select sc.sid
        from
            sc,
            course,
            teacher
        where
            sc.cid = course.cid
            and course.tid = teacher.tid
            and teacher.tname = "张三"
    );

select tid from teacher WHERE Tname= '张三';

select cid
from course
WHERE TId in(
        select tid
        from teacher
        WHERE Tname = '张三'
    );

select distinct sid
from sc
where CId IN (
        select cid
        from course
        WHERE TId in(
                select tid
                from teacher
                WHERE
                    Tname = '张三'
            )
    );

select distinct sid
from sc
WHERE sid not in (
        select distinct sid
        from sc
        where CId IN (
                select cid
                from course
                WHERE TId in(
                        select
                            tid
                        from
                            teacher
                        WHERE
                            Tname = '张三'
                    )
            )
    );

select *
from student
WHERE student.sid not in (
        select distinct sid
        from sc
        where CId IN (
                select cid
                from course
                WHERE TId in(
                        select
                            tid
                        from
                            teacher
                        WHERE
                            Tname = '张三'
                    )
            )
    );

-- ========================================================

-- 11 查询两门及其以上不及格课程的同学的学号，姓名及其平均成绩

select
    student.SId,
    student.Sname,
    b.avg
from student
    RIGHT JOIN (
        select
            sid,
            AVG(score) as avg
        from sc
        where sid in (
                select sid
                from sc
                where
                    score < 60
                GROUP BY sid
                HAVING
                    count(score) > 1
            )
        GROUP BY
            sid
    ) b on student.sid = b.sid;

select sid, COUNT(cid) from sc WHERE score <=60 GROUP BY sid;

SELECT *
from student s
    JOIN (
        select
            sid,
            COUNT(cid) counts
        from sc
        WHERE score <= 60
        GROUP BY
            sid
    ) a on s.SId = a.sid
WHERE counts >= 2;

select
    sid,
    round(AVG(score)) avg
from sc
WHERE sid in (
        SELECT s.sid
        from student s
            JOIN (
                select
                    sid,
                    COUNT(cid) counts
                from sc
                WHERE
                    score <= 60
                GROUP BY
                    sid
            ) a on s.SId = a.sid
        WHERE counts >= 2
    )
GROUP BY sid;

select
    distinct a.sid,
    a.sname,
    b.avg
from (
        SELECT s.sid, sname
        from student s
            JOIN (
                select
                    sid,
                    COUNT(cid) counts
                from sc
                WHERE
                    score <= 60
                GROUP BY
                    sid
            ) a on s.SId = a.sid
        WHERE counts >= 2
    ) a
    JOIN (
        select
            sid,
            round(AVG(score)) avg
        from sc
        WHERE sid in (
                SELECT s.sid
                from student s
                    JOIN (
                        select
                            sid,
                            COUNT(cid) counts
                        from
                            sc
                        WHERE
                            score <= 60
                        GROUP BY
                            sid
                    ) a on s.SId = a.sid
                WHERE
                    counts >= 2
            )
        GROUP BY sid
    ) b;

--===========================================================

--12 检索" 01 "课程分数小于 60，按分数降序排列的学生信息

select student.*, sc.score
from student, sc
where
    student.sid = sc.sid
    and sc.score < 60
    and cid = "01"
ORDER BY sc.score DESC;

select Sid, score
from sc
WHERE CId = 01 AND score < 60
ORDER BY score DESC;

select s.*, a.score
from student s
    join (
        select Sid, score
        from sc
        WHERE
            CId = 01
            AND score < 60
        ORDER BY
            score DESC
    ) a on s.sid = a.sid
ORDER BY score desc;

--=======================================================================

-- 13 按平均成绩从高到低显示所有学生的所有课程的成绩以及平均成绩

select *
from sc
    left join (
        select
            sid,
            avg(score) as avscore
        from sc
        group by
            sid
    ) r on sc.sid = r.sid
order by avscore desc;

select sid, AVG(score) avs from sc GROUP BY sid ORDER BY avs desc ;

select sc.*, a.avs
from sc
    join (
        select
            sid,
            AVG(score) avs
        from sc
        GROUP BY sid
        ORDER BY
            avs desc
    ) a on sc.sid = a.sid
ORDER BY avs desc;

--=========================================================================

-- 14 查询各科成绩最高分、最低分和平均分:

-- 以如下形式显示：课程 ID，课程 name，最高分，最低分，平均分，及格率，中等率，优良率，优秀率

-- 及格为>=60，中等为：70-80，优良为：80-90，优秀为：>=90

select
    sc.CId,
    max(sc.score) as 最高分,
    min(sc.score) as 最低分,
    AVG(sc.score) as 平均分,
    count(*) as 选修人数,
    sum(
        case
            when sc.score >= 60 then 1
            else 0
        end
    ) / count(*) as 及格率,
    sum(
        case
            when sc.score >= 70
            and sc.score < 80 then 1
            else 0
        end
    ) / count(*) as 中等率,
    sum(
        case
            when sc.score >= 80
            and sc.score < 90 then 1
            else 0
        end
    ) / count(*) as 优良率,
    sum(
        case
            when sc.score >= 90 then 1
            else 0
        end
    ) / count(*) as 优秀率
from sc
GROUP BY sc.CId
ORDER BY
    count(*) DESC,
    sc.CId ASC;

select * from course;

select * from sc;

select c.cid,c.Cname,sc.* from course c JOIN sc GROUP BY c.CId ;

select cid, MAX(score)
from sc
WHERE cid in (
        select cid
        from course
    )
GROUP BY cid;

select cid, min(score)
from sc
WHERE cid in (
        select cid
        from course
    )
GROUP BY cid;

select cid, avg(score)
from sc
WHERE cid in (
        select cid
        from course
    )
GROUP BY cid;

select
    cid,
    COUNT(score) passcount
from sc
WHERE cid in (
        select cid
        from
            course
    )
    and score >= 60
GROUP BY cid;

select cid, COUNT(score) counts
from sc
WHERE cid in (
        select cid
        from course
    )
GROUP BY cid;

select
    a.cid,
    a.passcount / b.counts passpoint,
    b.counts
from (
        select
            cid,
            COUNT(score) passcount
        from sc
        WHERE cid in (
                select cid
                from
                    course
            )
            and score >= 60
        GROUP BY cid
    ) a
    JOIN (
        select
            cid,
            COUNT(score) counts
        from sc
        WHERE cid in (
                select cid
                from course
            )
        GROUP BY
            cid
    ) b on a.cid = b.cid;

select
    distinct passs.cid,
    passs.*
from course c
    join (
        select
            a.cid,
            a.passcount / b.counts passpoint,
            b.counts
        from (
                select
                    cid,
                    COUNT(score) passcount
                from sc
                WHERE cid in (
                        select
                            cid
                        from
                            course
                    )
                    and score >= 60
                GROUP BY
                    cid
            ) a
            JOIN (
                select
                    cid,
                    COUNT(score) counts
                from sc
                WHERE cid in (
                        select
                            cid
                        from
                            course
                    )
                GROUP BY
                    cid
            ) b on a.cid = b.cid
    ) passs;

select
    distinct passs.cid,
    passs.*
from course c
    join (
        select
            a.cid,
            a.avgcount / b.counts avgpoint,
            b.counts
        from (
                select
                    cid,
                    COUNT(score) avgcount
                from sc
                WHERE cid in (
                        select
                            cid
                        from
                            course
                    )
                    and score >= 70
                    AND score <= 80
                GROUP BY
                    cid
            ) a
            JOIN (
                select
                    cid,
                    COUNT(score) counts
                from sc
                WHERE cid in (
                        select
                            cid
                        from
                            course
                    )
                GROUP BY
                    cid
            ) b on a.cid = b.cid
    ) passs;

select
    distinct passs.cid,
    passs.*
from course c
    join (
        select
            a.cid,
            a.okcount / b.counts okpoint,
            b.counts
        from (
                select
                    cid,
                    COUNT(score) okcount
                from sc
                WHERE cid in (
                        select
                            cid
                        from
                            course
                    )
                    and score >= 80
                    AND score <= 90
                GROUP BY
                    cid
            ) a
            JOIN (
                select
                    cid,
                    COUNT(score) counts
                from sc
                WHERE cid in (
                        select
                            cid
                        from
                            course
                    )
                GROUP BY
                    cid
            ) b on a.cid = b.cid
    ) passs;

select
    distinct passs.cid,
    passs.*
from course c
    join (
        select
            a.cid,
            a.goodcount / b.counts goodpoint,
            b.counts
        from (
                select
                    cid,
                    COUNT(score) goodcount
                from sc
                WHERE cid in (
                        select
                            cid
                        from
                            course
                    )
                    and score >= 90
                GROUP BY
                    cid
            ) a
            JOIN (
                select
                    cid,
                    COUNT(score) counts
                from sc
                WHERE cid in (
                        select
                            cid
                        from
                            course
                    )
                GROUP BY
                    cid
            ) b on a.cid = b.cid
    ) passs;

select
    distinct c.cid,
    c.Cname,
    maxs.maxscore,
    mins.minscore,
    avgs.avgscore,
    passdeadline.passpoint,
    d.cidcount -- passavg.avgpoint,
    -- passok.okpoint
from course c
    join (
        select
            cid,
            MAX(score) maxscore
        from sc
        WHERE cid in (
                select cid
                from course
            )
        GROUP BY
            cid
    ) maxs on c.CId = maxs.cid
    join (
        select
            cid,
            min(score) minscore
        from sc
        WHERE cid in (
                select cid
                from course
            )
        GROUP BY
            cid
    ) mins on mins.cid = maxs.cid
    join (
        select
            cid,
            avg(score) avgscore
        from sc
        WHERE cid in (
                select cid
                from course
            )
        GROUP BY
            cid
    ) avgs on avgs.cid = mins.cid
    join (
        select
            a.cid,
            a.passcount / b.counts passpoint,
            b.counts
        from (
                select
                    cid,
                    COUNT(score) passcount
                from sc
                WHERE cid in (
                        select
                            cid
                        from
                            course
                    )
                    and score >= 60
                GROUP BY
                    cid
            ) a
            JOIN (
                select
                    cid,
                    COUNT(score) counts
                from sc
                WHERE cid in (
                        select
                            cid
                        from
                            course
                    )
                GROUP BY
                    cid
            ) b on a.cid = b.cid
    ) passdeadline on passdeadline.cid = avgs.cid
    join (
        select
            cid,
            COUNT(score) cidcount
        from sc
        group by cid
    ) d;

select cid ,COUNT(score) cidcount from sc group by cid;

-- ===========================================================

-- 15 按各科成绩进行排序，并显示排名， Score 重复时保留名次空缺

SELECT cid from course;

select * from sc ;

select
    a.id,
    a.cid,
    a.score,
    a.sid,
    b.sid,
    b.score -- count(b.score)+1
from sc as a
    left join sc as b on a.cid = b.cid
    /* and a.score < b.score  > <  */
    -- GROUP BY a.cid, a.sid
ORDER BY
    a.cid,
    a.sid,
    a.score desc,
    b.score desc;

;

select
    a.cid,
    a.sid,
    a.score,
    count(b.score) + 1 as ranks
from sc as a
    left join sc as b on a.score < b.score and a.cid = b.cid
group by
    a.cid,
    a.sid,
    a.score
order by a.cid, ranks ASC;

select
    *,
    RANK() OVER (
        PARTITION BY cid
        ORDER BY
            score DESC
    ) ranks
from sc;

-- =========================================================================

-- 16 查询学生的总成绩，并进行排名，总分重复时保留名次空缺

-- sql or mysql-sql 高级语法

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

---===============================================================================

set @crank=0;

select
    q.sid,
    total,
    @crank := @crank + 1 as rank
from(
        select
            sc.sid,
            sum(sc.score) as total
        from sc
        group by sc.sid
        order by total desc
    ) q;

select sid,SUM(score) sums from sc GROUP BY sid ORDER BY sums ;

-- ============================================================================ADD

-- 17 统计各科成绩各分数段人数：课程编号，课程名称，[100-85]，[85-70]，[70-60]，[60-0] 及所占百分比

select
    course.cname,
    course.cid,
    sum(
        case
            when sc.score <= 100
            and sc.score > 85 then 1
            else 0
        end
    ) as "[100-85]",
    sum(
        case
            when sc.score <= 85
            and sc.score > 70 then 1
            else 0
        end
    ) as "[85-70]",
    sum(
        case
            when sc.score <= 70
            and sc.score > 60 then 1
            else 0
        end
    ) as "[70-60]",
    sum(
        case
            when sc.score <= 60
            and sc.score > 0 then 1
            else 0
        end
    ) as "[60-0]"
from sc
    left join course on sc.cid = course.cid
group by sc.cid;

-- 同15题

-- =================================================================ADD

-- 18 查询各科成绩前三名的记录

select
    sc.CId,
    sc.SId,
    sc.score
from sc
where (
        select count(*)
        from sc as a
        where
            sc.cid = a.cid
            and sc.score < a.score
    ) < 3
order by cid asc, sc.score desc;

select a.sid, a.cid, a.score
from sc a
    left join sc b on a.cid = b.cid and a.score < b.score
group by a.cid, a.sid
having count(b.cid) < 3
order by a.cid;

SELECT cid, sid, score
from (
        select
            a.cid,
            a.sid,
            a.score,
            COUNT(b.score) counts
        from (
                select
                    a.cid,
                    b.sid,
                    b.score
                from course a
                    join (
                        select
                            *
                        from
                            sc
                        ORDER BY
                            cid,
                            score
                    ) b on a.CId = b.cid
                ORDER BY
                    a.CId,
                    score desc
            ) a
            JOIN (
                select
                    a.cid,
                    b.sid,
                    b.score
                from course a
                    join (
                        select
                            *
                        from
                            sc
                        ORDER BY
                            cid,
                            score
                    ) b on a.CId = b.cid
                ORDER BY
                    a.CId,
                    score desc
            ) b on a.cid = b.cid
            AND a.score >= b.score
        GROUP BY
            a.CId,
            a.sid
    ) a
WHERE counts >= 4
ORDER BY cid;

select * from sc ORDER BY cid, score desc;

select a.*, b.*
from course a
    join (
        select *
        from sc
        ORDER BY
            cid,
            score desc
        LIMIT 3
    ) b
ORDER BY
    a.cid,
    b.cid,
    b.score desc;

-- ========================================================================

-- 19 查询每门课程被选修的学生数

select cid ,COUNT(score) from sc GROUP BY cid;

-- =====================================================================

-- 20 查询出只选修两门课程的学生学号和姓名

select
    student.SId,
    student.Sname
from sc, student
where student.SId = sc.SId
GROUP BY sc.SId
HAVING count(*) = 2;

SELECT sid, COUNT(score) counts
FROM sc
GROUP BY sid
HAVING counts = 2;

select *
from (
        SELECT
            sid,
            COUNT(score) counts
        FROM sc
        GROUP BY sid
    ) a
where counts = 2;

-- ============================================================================

-- 21 查询男生、女生人数

SELECT COUNT(sid) from student WHERE ssex='女';

SELECT COUNT(sid) from student WHERE ssex='男';

-- ============================================================================ADD

-- 22 查询名字中含有「风」字的学生信息

select * from student WHERE Sname LIKE '%风%';

-- ==================================================================================ADD

-- 23 查询同名同性学生名单，并统计同名人数

select sname, count(*) from student group by sname having count(*)>1;

select a.sid, COUNT(a.sid)
FROM student a
    JOIN student b on a.SId != b.sid and a.Sname = b.Sname AND a.Ssex = b.Ssex;

-- ===============================================================================================ADD

-- TODO

-- 24 查询 1990 年出生的学生名单

SELECT * FROM student WHERE YEAR(student.Sage)=1990;

--25 查询每门课程的平均成绩，结果按平均成绩降序排列，平均成绩相同时，按课程编号升序排列

SELECT cid, AVG(score) avc
FROM sc
GROUP BY cid
ORDER BY avc DESC, CId asc;

--======================================================================

--26 查询平均成绩大于等于 85 的所有学生的学号、姓名和平均成绩

SELECT sid, AVG(score) avc FROM sc GROUP BY sid HAVING avc >=85;

SELECT *
from student a
    JOIN (
        SELECT
            sid,
            AVG(score) avc
        FROM sc
        GROUP BY sid
        HAVING
            avc >= 85
    ) b on a.sid = b.sid;

--==================================================================

--27 查询课程名称为「数学」，且分数低于 60 的学生姓名和分数

select student.sname, sc.score
from student, sc, course
where
    student.sid = sc.sid
    and course.cid = sc.cid
    and course.cname = "数学"
    and sc.score < 60;

SELECT cid from course WHERE course.Cname = '数学';

SELECT *
from sc
WHERE cid in (
        SELECT cid
        from course
        WHERE
            course.Cname = '数学'
    )
HAVING score < 60;

select a.Sname, b.score
from student a
    JOIN (
        SELECT *
        from sc
        WHERE cid in (
                SELECT cid
                from course
                WHERE
                    course.Cname = '数学'
            )
        HAVING
            score < 60
    ) b on a.SId = b.sid;

---======================================================

--28 查询所有学生的课程及分数情况（存在学生没成绩，没选课的情况）

select * from student a LEFT JOIN sc b on a.sid =b.sid;

--29 查询任何一门课程成绩在 70 分以上的姓名、课程名称和分数

select
    student.sname,
    course.cname,
    sc.score
from student, course, sc
where
    sc.score > 70
    and student.sid = sc.sid
    and sc.cid = course.cid;

select * from sc WHERE score> 70 GROUP BY sid ;

SELECT a.Sname, b.*
from student a
    JOIN (
        select *
        from sc
        WHERE score > 70
        GROUP BY
            sid
    ) b ON a.SId = b.sid;

-- 30 查询不及格的课程

SELECT distinct cid from sc WHERE score<60;

--31 查询课程编号为 01 且课程成绩在 80 分以上的学生的学号和姓名

select
    student.sid,
    student.sname,
    Sc.*
from student, sc
where
    cid = "01"
    and score >= 80
    and student.sid = sc.sid;

select sid from sc WHERE cid=1 And score>=80;

--32 求每门课程的学生人数

select cid,COUNT(sid) from sc GROUP BY cid ;

-- 33 成绩不重复，查询选修「张三」老师所授课程的学生中，成绩最高的学生信息及其成绩

--用having max()理论上也是对的，但是下面那种按分数排序然后取limit 1的更直观可靠

select
    student.*,
    sc.score,
    sc.cid
from
    student,
    teacher,
    course,
    sc
where
    teacher.tid = course.tid
    and sc.sid = student.sid
    and sc.cid = course.cid
    and teacher.tname = "张三"
having max(sc.score);

SELECT TId from teacher WHERE Tname='张三';

SELECT CId
from course
WHERE TId in (
        SELECT TId
        from teacher
        WHERE Tname = '张三'
    );

SELECT *
FROM sc
WHERE cid in (
        SELECT CId
        from course
        WHERE TId in (
                SELECT TId
                from teacher
                WHERE
                    Tname = '张三'
            )
    )
ORDER BY score desc
LIMIT 1;

--=======================================================================================

--34 成绩有重复的情况下，查询选修「张三」老师所授课程的学生中，成绩最高的学生信息及其成绩

SELECT *
FROM sc
WHERE cid in (
        SELECT CId
        from course
        WHERE TId in (
                SELECT TId
                from teacher
                WHERE
                    Tname = '张三'
            )
    )
ORDER BY score desc
LIMIT 1;

select
    student.*,
    sc.score,
    sc.cid
from
    student,
    teacher,
    course,
    sc
where
    teacher.tid = course.tid
    and sc.sid = student.sid
    and sc.cid = course.cid
    and teacher.tname = "张三"
    and sc.score = (
        SELECT score
        FROM sc
        WHERE cid in (
                SELECT CId
                from course
                WHERE TId in (
                        SELECT
                            TId
                        from
                            teacher
                        WHERE
                            Tname = '张三'
                    )
            )
        ORDER BY score desc
        LIMIT 1
    );
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
---=================================================================================================
-- 35 查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩
SELECT
    a.sid,
    a.cid,
    a.score,
    b.sid,
    b.cid 
FROM
    ( SELECT sid, cid, score FROM sc ) a
    LEFT JOIN ( SELECT sid, cid, score FROM sc ) b ON a.score = b.score 
WHERE
    a.cid <> b.cid 
ORDER BY
    a.sid,
    a.cid,
    b.sid;


SELECT a.*, b.*
from sc a
    JOIN sc b on a.SId != b.SId AND a.CId != b.CId and a.score = b.score
GROUP BY a.sid
ORDER BY a.SId, a.CId;

select a.sid asid,a.cid acid,b.sid bsid, b.cid bcid,a.score
from sc a
    join sc b on a.sid != b.sid and a.cid != b.cid and a.score = b.score
GROUP BY a.sid;

select *
from (
        select a.sid asid,a.cid acid,b.sid bsid, b.cid bcid,a.score
        from sc a
            join sc b on a.sid != b.sid and a.cid != b.cid and a.score = b.score
        GROUP BY a.sid
    ) a GROUP BY asid,acid,bsid,bcid;

-- 36 查询每门功成绩最好的前两名

select CId FROM course;

select a.cid, b.sid, b.score
from course a
    join (
        select *
        from sc
        ORDER BY
            cid,
            score
    ) b on a.CId = b.cid
ORDER BY a.CId, score desc;

select
    a.cid,
    a.sid,
    a.score,
    COUNT(b.score)
from (
        select
            a.cid,
            b.sid,
            b.score
        from course a
            join (
                select *
                from sc
                ORDER BY
                    cid,
                    score
            ) b on a.CId = b.cid
        ORDER BY
            a.CId,
            score desc
    ) a
    JOIN (
        select
            a.cid,
            b.sid,
            b.score
        from course a
            join (
                select *
                from sc
                ORDER BY
                    cid,
                    score
            ) b on a.CId = b.cid
        ORDER BY
            a.CId,
            score desc
    ) b on a.cid = b.cid
    AND a.score >= b.score
GROUP BY a.CId, a.sid;

SELECT cid, sid, score
from (
        select
            a.cid,
            a.sid,
            a.score,
            COUNT(b.score) counts
        from (
                select
                    a.cid,
                    b.sid,
                    b.score
                from course a
                    join (
                        select
                            *
                        from
                            sc
                        ORDER BY
                            cid,
                            score
                    ) b on a.CId = b.cid
                ORDER BY
                    a.CId,
                    score desc
            ) a
            JOIN (
                select
                    a.cid,
                    b.sid,
                    b.score
                from course a
                    join (
                        select
                            *
                        from
                            sc
                        ORDER BY
                            cid,
                            score
                    ) b on a.CId = b.cid
                ORDER BY
                    a.CId,
                    score desc
            ) b on a.cid = b.cid
            AND a.score >= b.score
        GROUP BY
            a.CId,
            a.sid
    ) a
WHERE counts >= 5
ORDER BY cid;

--===============================================================

-- 37 统计每门课程的学生选修人数（超过 5 人的课程才统计）

--

select cid ,COUNT(score) counts from sc GROUP BY cid HAVING counts>5;

--=======================================================================

-- 38 检索至少选修两门课程的学生学号

select sid, COUNT(score) counts
from sc
GROUP BY sid
HAVING counts >= 2;

--============================================================

--39 查询选修了全部课程的学生信息

select sid ,COUNT(score) counts from sc GROUP BY sid HAVING counts=3;

--===================================================================ADD

--================================================================================

--================================================================================

--================================================================================

--================================================================================

--================================================================================

--================================================================================

--================================================================================

--================================================================================

--================================================================================

--date 日期相关 ，注意mysql日期相关的函数。

-- 40 查询各学生的年龄，只按年份来算

SELECT * from student ;

SELECT
    *,
    TIMESTAMPDIFF(YEAR, student.Sage, CURDATE()) as 学生年龄
from student;

--====================================================================

--41

select
    student.SId as 学生编号,
    student.Sname as 学生姓名,
    TIMESTAMPDIFF(YEAR, student.Sage, CURDATE()) as 学生年龄
from student;

--===================================================================

--42

select *
from student
where
    WEEKOFYEAR(student.Sage) = WEEKOFYEAR(CURDATE());

--=========================================================================

--43

select *
from student
where
    WEEKOFYEAR(student.Sage) = WEEKOFYEAR(CURDATE()) + 1;

--====================================================================

--44

select * from student where MONTH(student.Sage)=MONTH(CURDATE());

--=======================================================================

--45

select * from student where MONTH(student.Sage)=MONTH(CURDATE())+1;
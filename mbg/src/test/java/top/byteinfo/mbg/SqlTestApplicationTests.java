package top.byteinfo.mbg;

import com.example.sqltest.mbg.entity.Course;
import com.example.sqltest.mbg.entity.Sc;
import com.example.sqltest.mbg.entity.Student;
import com.example.sqltest.mbg.entity.Teacher;
import com.example.sqltest.mbg.mapper.CourseMapper;
import com.example.sqltest.mbg.mapper.ScMapper;
import com.example.sqltest.mbg.mapper.StudentMapper;
import com.example.sqltest.mbg.mapper.TeacherMapper;
import com.example.sqltest.model.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@SpringBootTest
class SqlTestApplicationTests {

    @Resource
    ScMapper scMapper;

    @Resource
    StudentMapper studentMapper;

    @Resource
    TeacherMapper teacherMapper;

    @Resource
    CourseMapper courseMapper;

    @Test
    void contextLoads() {
        List<Sc> scList = scMapper.selectAll();
//        log.info(Jackson.toString(scMapper.selectAll()));
        List<Student> studentList = studentMapper.selectAll();
//        log.info(Jackson.toString(studentList));

        List<Teacher> teacherList = teacherMapper.selectAll();

        String s = "zhang";
        boolean b = s.startsWith("zh");
        HashMap map = new HashMap<String, HashMap<String, String>>();
        for (Student student : studentList) {
            Map<String, Integer> mapBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
            if (mapBySid.get("01") == null || mapBySid.get("02") == null)
                continue;
            if (mapBySid.get("01").compareTo(mapBySid.get("02")) > 0) {
                map.put(student.getSid(), mapBySid);
            }
        }
        Set set = map.keySet();
        List<Student> studentList1 = studentList.stream().filter(student -> map.containsKey(student.getSid())).collect(Collectors.toList());
        List<Sc> scList1 = scList.stream().filter(sc -> map.containsKey(sc.getSid())).collect(Collectors.toList());

        List<StudentCourseScDTO> studentCourseScDTOList = studentList.stream().filter(student -> map.containsKey(student.getSid())).map(
                student -> StudentCourseScDTO.builder()
                        .sid(student.getSid())
                        .courseScDTOList(
                                scList1.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid()))
                                        .map(sc -> CourseScDTO.builder().cid(sc.getCid()).score(sc.getScore()).build())
                                        .collect(Collectors.toList()))
                        .build()
        ).collect(Collectors.toList());

        log.info(map.toString());
        log.info(Jackson.toString(studentList1));
        log.info(Jackson.toString(scList1));
        log.info(Jackson.toString(studentCourseScDTOList));
    }

    @Test
    void t11() {
        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();
        HashMap map = new HashMap<String, HashMap<String, String>>();

        for (Student student : studentList) {
            Map<String, Integer> mapBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
            if (mapBySid.get("01") != null && mapBySid.get("02") != null)
                map.put(student.getSid(), mapBySid);
        }

        List<StudentCourseScDTO> studentCourseScDTOList = studentList.stream().filter(student -> map.containsKey(student.getSid())).map(
                student -> StudentCourseScDTO.builder()
                        .sid(student.getSid())
                        .courseScDTOList(
                                scList.stream().filter(sc -> map.containsKey(sc.getSid()))
                                        .filter(sc -> Objects.equals(sc.getSid(), student.getSid()))
                                        .map(sc -> CourseScDTO.builder().cid(sc.getCid()).score(sc.getScore()).build())
                                        .collect(Collectors.toList()))
                        .build()
        ).collect(Collectors.toList());

        log.info(Jackson.toString(map));
        log.info(Jackson.toString(studentCourseScDTOList));
    }

    @Test
    void t12() {
        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();
        Map map = new HashMap<String, HashMap<String, String>>();

        for (Student student : studentList) {
            Map<String, Integer> mapBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
            if (mapBySid.get("01") != null)
                map.put(student.getSid(), mapBySid);
        }
        List<StudentCourseScDTO> studentCourseScDTOList = studentList.stream().filter(student -> map.containsKey(student.getSid())).map(
                student -> StudentCourseScDTO.builder()
                        .sid(student.getSid())
                        .courseScDTOList(
                                scList.stream().filter(sc -> map.containsKey(sc.getSid()))
                                        .filter(sc -> Objects.equals(sc.getSid(), student.getSid()))
                                        .map(
                                                sc -> {
                                                    CourseScDTO courseScDTO = new CourseScDTO();
                                                    if (sc.getCid() != null) {
                                                        courseScDTO.setCid(sc.getCid());
                                                        courseScDTO.setScore(sc.getScore());
                                                    } else {
                                                    }
                                                    return courseScDTO;
                                                }
                                        )
                                        .collect(Collectors.toList()))
                        .build()
        ).peek(studentCourseScDTO -> {
            if (!studentCourseScDTO.getCourseScDTOList().stream().map(CourseScDTO::getCid).collect(Collectors.toList()).contains("02")) {
                List<CourseScDTO> courseScDTOList = studentCourseScDTO.getCourseScDTOList();
                courseScDTOList.add(CourseScDTO.builder().cid("02").build());
                studentCourseScDTO.setCourseScDTOList(courseScDTOList);
            }
            List<CourseScDTO> courseScDTOList = studentCourseScDTO.getCourseScDTOList();
            courseScDTOList.sort((a, b) -> b.getCid().compareTo(a.getCid()));
            studentCourseScDTO.setCourseScDTOList(courseScDTOList);
        }).collect(Collectors.toList());


        log.info(Jackson.toString(studentCourseScDTOList));
        log.info(Jackson.toString(map));

    }

    @Test
    void t13() {
        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();
        HashMap map = new HashMap<String, HashMap<String, String>>();

        for (Student student : studentList) {
            Map<String, Integer> mapBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
            if (mapBySid.get("01") == null && mapBySid.get("02") != null)
                map.put(student.getSid(), mapBySid);
        }

        List<StudentCourseScDTO> studentCourseScDTOList = studentList.stream().filter(student -> map.containsKey(student.getSid())).map(
                student -> StudentCourseScDTO.builder()
                        .sid(student.getSid())
                        .courseScDTOList(
                                scList.stream().filter(sc -> map.containsKey(sc.getSid()))
                                        .filter(sc -> Objects.equals(sc.getSid(), student.getSid()))
                                        .map(sc -> CourseScDTO.builder().cid(sc.getCid()).score(sc.getScore()).build())
                                        .collect(Collectors.toList()))
                        .build()
        ).collect(Collectors.toList());

        log.info(Jackson.toString(map));
        log.info(Jackson.toString(studentCourseScDTOList));
    }

    /**
     * 2
     * ?????????????????????????????? 60 ?????????????????????????????????????????????????????????
     */
    @Test
    void t2() {
        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();
        HashMap map = new HashMap<String, HashMap<String, String>>();

        for (Student student : studentList) {
            Map<String, Integer> mapBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
            long count = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).map(Sc::getCid).count();
            int sum = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).mapToInt(Sc::getScore).sum();
            if (sum == 0)
                continue;
            int average = sum / ((int) count);
            if (average >= 60) {
                map.put(student.getSid(), mapBySid);
            }
        }
        List<StudentCourseScDTO> studentCourseScDTOList = studentList.stream().filter(student -> map.containsKey(student.getSid())).map(
                student -> StudentCourseScDTO.builder()
                        .sid(student.getSid())
                        .courseScDTOList(
                                scList.stream()
                                        .filter(sc -> map.containsKey(sc.getSid()))
                                        .filter(sc -> Objects.equals(sc.getSid(), student.getSid()))
                                        .map(sc -> CourseScDTO.builder().cid(sc.getCid()).score(sc.getScore()).build())
                                        .collect(Collectors.toList())
                        )
                        .build()
        ).collect(Collectors.toList());
        log.info(Jackson.toString(studentCourseScDTOList));
        log.info(Jackson.toString(map));
    }

    /**
     * ????????? SC ??????????????????????????????
     */
    @Test
    void t3() {
        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();


//        List<StudentCourseScDTO> studentCourseScDTOList = studentList.stream().filter(student -> scList.stream().map(Sc::getSid).collect(Collectors.toList()).contains(student.getSid())).map(
//                student -> StudentCourseScDTO.builder()
//                        .sid(student.getSid())
//                        .courseScDTOList(
//                                scList.stream()
//                                        .filter(sc -> Objects.equals(sc.getSid(), student.getSid()))
//                                        .map(sc -> CourseScDTO.builder().cid(sc.getCid()).score(sc.getScore()).build())
//                                        .collect(Collectors.toList())
//                        ).build()
//        ).collect(Collectors.toList());
        List<Student> studentList1 = studentList.stream().filter(student -> scList.stream().map(Sc::getSid).collect(Collectors.toList()).contains(student.getSid())).collect(Collectors.toList());


        log.info(Jackson.toString(studentList1));
    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????????????????(????????????????????? null )
     */
    @Test
    void t4() {
        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();

        List<StudentT4DTO> studentT4DTOList = studentList.stream().map(
                        student -> StudentT4DTO.builder()
                                .sid(student.getSid())
                                .name(student.getSname())
                                .courseCount((int) scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).map(Sc::getCid).count())
                                .scSum(scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).mapToInt(Sc::getScore).sum())
                                .build()
                ).peek(studentT4DTO ->
                        {
                            if (studentT4DTO.getScSum() == 0)
                                studentT4DTO.setScSum(null);

                        }
                )
                .collect(Collectors.toList());

        log.info(Jackson.toString(studentT4DTOList));
    }

    @Test
    void t41() {

    }

    @Test
    void t5() {
        List<Teacher> teacherList = teacherMapper.selectAll();
        List<Teacher> teacherList1 = teacherList.stream().filter(teacher -> teacher.getTname().startsWith("???")).collect(Collectors.toList());
        long count = teacherList.stream().filter(teacher -> teacher.getTname().startsWith("???")).count();
        log.info(Jackson.toString(teacherList1) + "\n" + count);

    }

    /**
     * ??????????????????????????????????????????????????????
     */
    @Test
    void t6() {
        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();
        List<Teacher> teacherList = teacherMapper.selectAll();
        List<Course> courseList = courseMapper.selectAll();
        //TODO
        List<String> stringList = teacherList.stream().filter(teacher -> Objects.equals(teacher.getTname(), "??????")).map(Teacher::getTid).collect(Collectors.toList());

        List<String> cIdList = courseList.stream().filter(
                course ->
                        teacherList.stream()
                                .filter(teacher -> Objects.equals(teacher.getTname(), "??????"))
                                .map(Teacher::getTid)
                                .collect(Collectors.toList())
                                .contains(course.getTid())
        ).map(Course::getCid).collect(Collectors.toList());


        List<Student> studentList1 = studentList.stream().filter(
                student -> scList.stream().filter(
                        sc -> courseList.stream().filter(
                                        course ->
                                                teacherList.stream().filter(teacher -> Objects.equals(teacher.getTname(), "??????"))
                                                        .map(Teacher::getTid)
                                                        .collect(Collectors.toList())
                                                        .contains(course.getTid())

                                )
                                .map(Course::getCid).collect(Collectors.toList()).contains(sc.getCid())
                ).map(Sc::getSid).collect(Collectors.toList()).contains(student.getSid())
        ).collect(Collectors.toList());

        log.info(Jackson.toString(studentList1));
    }

    /**
     * ????????????????????????????????????????????????
     */
    @Test
    void t7() {
        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();
        HashMap map = new HashMap<String, HashMap<String, String>>();

        for (Student student : studentList) {
            Map<String, Integer> mapBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
            if (mapBySid.get("01") != null && mapBySid.get("02") != null && mapBySid.get("03") != null)
                continue;

            map.put(student.getSid(), mapBySid);
        }
        Set set = map.keySet();
        List<Student> studentList1 = studentList.stream().filter(student -> set.contains(student.getSid())).collect(Collectors.toList());
        log.info(Jackson.toString(studentList1));
    }

    /**
     * ????????????????????????????????????" 01 "???????????????????????????????????????
     */
    @Test
    void t8() {

        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();

        List<String> cIdList = scList.stream().filter(sc -> Objects.equals(sc.getSid(), "09")).map(Sc::getCid).collect(Collectors.toList());
        List<String> sidList = scList.stream().filter(sc -> cIdList.contains(sc.getCid())).map(Sc::getSid).distinct().collect(Collectors.toList());
        List<Student> studentList1 = studentList.stream().filter(student -> sidList.contains(student.getSid())).filter(student -> !Objects.equals(student.getSid(), "09")).collect(Collectors.toList());

        log.info(Jackson.toString(studentList1));

    }

    /**
     * ?????????" 01 "??????????????????????????? ????????????????????????????????????
     * ??????
     */
    @Test
    void t9() {
        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();

        List<String> cIdList = scList.stream().filter(sc -> Objects.equals(sc.getSid(), "01")).map(Sc::getCid).collect(Collectors.toList());

//        HashMap map = new HashMap<String, HashMap<String, String>>();
//        for (Student student : studentList) {
//            Map<String, Integer> mapBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
//            if (mapBySid.get("01") != null && mapBySid.get("02") != null && mapBySid.get("03") != null)
//                continue;
//
//            map.put(student.getSid(), mapBySid);
//        }

        Set set = new HashSet<>();
        for (Student student : studentList) {
            List<String> cIdListBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).map(Sc::getCid).collect(Collectors.toList());

            int i = 0, j = 0;
            for (String s : cIdListBySid) {
                if (cIdList.contains(s))
                    ++i;
            }
            for (String s : cIdList) {
                if (cIdListBySid.contains(s))
                    ++j;
            }
            if (i == j && i == cIdList.size()) {
                set.add(student.getSid());
            }
        }
        List<Student> studentList1 = studentList.stream().filter(student -> set.contains(student.getSid())).collect(Collectors.toList());

        log.info(Jackson.toString(studentList1));
    }

    /**
     * ???????????????"??????"?????????????????????????????????????????????
     */
    @Test
    void t10() {

        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();
        List<Teacher> teacherList = teacherMapper.selectAll();
        List<Course> courseList = courseMapper.selectAll();

        List<String> tIdList = teacherList.stream().filter(teacher -> Objects.equals(teacher.getTname(), "??????")).map(Teacher::getTid).collect(Collectors.toList());
        List<String> cIdList = courseList.stream().filter(course -> tIdList.contains(course.getTid())).map(Course::getCid).collect(Collectors.toList());
        List<String> sidList = scList.stream().filter(sc -> cIdList.contains(sc.getCid())).map(Sc::getSid).collect(Collectors.toList());
        List<Student> studentList0 = studentList.stream().filter(student -> !sidList.contains(student.getSid())).collect(Collectors.toList());


        List<Student> studentList1 = studentList.stream().filter(
                student -> !scList.stream().filter(
                        sc -> courseList.stream().filter(
                                        course ->
                                                teacherList.stream().filter(teacher -> Objects.equals(teacher.getTname(), "??????"))
                                                        .map(Teacher::getTid)
                                                        .collect(Collectors.toList())
                                                        .contains(course.getTid())

                                )
                                .map(Course::getCid)
                                .collect(Collectors.toList())
                                .contains(sc.getCid())
                ).map(Sc::getSid).collect(Collectors.toList()).contains(student.getSid())
        ).collect(Collectors.toList());

        log.info(Jackson.toString(studentList1));
    }

    /**
     *
     * ????????????????????????????????????????????????????????????????????????????????????
     */
    @Test
    void T11() {
        //        HashMap map = new HashMap<String, HashMap<String, String>>();
//        for (Student student : studentList) {
//            Map<String, Integer> mapBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
//            if (mapBySid.get("01") != null && mapBySid.get("02") != null && mapBySid.get("03") != null)
//                continue;
//
//            map.put(student.getSid(), mapBySid);
//        }

        Set set = new HashSet<>();
        List<Student> studentList = studentMapper.selectAll();
        List<Sc> scList = scMapper.selectAll();
//        Map map = new HashMap<>();
//        for (Student student : studentList) {
//            Map<String, Integer> scMapBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
//            map.put(student.getSid(), scMapBySid);
//        }
//        for (Student student : studentList) {
//            Map<String, Integer> mapBySid = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
//            int count = (int) scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).map(Sc::getCid).count();
//            int sum = scList.stream().filter(sc -> Objects.equals(sc.getSid(), student.getSid())).mapToInt(Sc::getScore).sum();
//            if (sum == 0)
//                continue;
//            int average = sum / ((int) count);
//            if (average >= 60) {
//                map.put(student.getSid(), mapBySid);
//            }
//        }

        List<String> sIdByPassList = studentList.stream().map(
                student -> StudentCourseScDTO.builder()
                        .sid(student.getSid())
                        .courseScDTOList(
                                scList.stream()
                                        .filter(sc -> Objects.equals(sc.getSid(), student.getSid()))
                                        .filter(sc -> sc.getScore() >= 60)
                                        .map(sc ->
                                                CourseScDTO.builder()
                                                        .cid(sc.getCid())
                                                        .score(sc.getScore())
                                                        .build()
                                        ).collect(Collectors.toList())
                        ).build()).filter(studentCourseScDTO -> studentCourseScDTO.getCourseScDTOList().size() > 1).map(StudentCourseScDTO::getSid).collect(Collectors.toList());

        List<StudentAveScDTO> studentAveScDTOList = studentList.stream().filter(student -> !sIdByPassList.contains(student.getSid())).map(
                student -> StudentAveScDTO.builder()
                        .sid(student.getSid())
                        .name(student.getSname())
                        .aveSc(null)
                        .build()
        ).peek(
                studentAveScDTO -> {
                    int count = (int) scList.stream().filter(sc -> Objects.equals(sc.getSid(), studentAveScDTO.getSid())).map(Sc::getCid).count();
                    int sum = scList.stream().filter(sc -> Objects.equals(sc.getSid(), studentAveScDTO.getSid())).mapToInt(Sc::getScore).sum();
                    if (count > 0) {
                        studentAveScDTO.setAveSc(sum / count);
                    }
                }
        ).collect(Collectors.toList());

        log.info(Jackson.toString(studentAveScDTOList));

    }

    /**
     * ??????" 01 "?????????????????? 60???????????????????????????????????????
     */
    @Test
    void T12() {
        List<Student> studentList = studentMapper.selectAll();
        List<Sc> scList = scMapper.selectAll();
        List<Sc> scList1 = scList.stream().filter(sc -> sc.getCid().equals("01")).filter(sc -> sc.getScore() < 60).collect(Collectors.toList());
        List<Student> studentList1 = studentList.stream().filter(student -> scList1.stream().map(Sc::getSid).collect(Collectors.toList()).contains(student.getSid())).collect(Collectors.toList());
        scList1.sort((a, b) -> (b.getScore().compareTo(a.getScore())));
        log.info(Jackson.toString(scList1));
    }

    /**
     * ???????????????????????????????????????????????????????????????????????????????????????
     */
    @Test
    void T13() {
        List<Student> studentList = studentMapper.selectAll();
        List<Sc> scList = scMapper.selectAll();
        List<StudentScDTO> studentScDTOList = studentList.stream().map(student -> StudentScDTO.builder().sid(student.getSid()).aveSc(0).courseScDTOList(null).build())
                .peek(
                        studentScDTO -> {
                            int sum = scList.stream().filter(sc -> sc.getSid().equals(studentScDTO.getSid())).mapToInt(Sc::getScore).sum();
                            int count = (int) scList.stream().filter(sc -> sc.getSid().equals(studentScDTO.getSid())).map(Sc::getCid).count();
                            int counts = 3;
                            if (count > 0) {
                                studentScDTO.setAveSc(sum / counts);
                            }
                        }
                ).peek(
                        studentScDTO ->
                                studentScDTO.setCourseScDTOList(scList.stream().filter(sc -> sc.getSid().equals(studentScDTO.getSid())).map(
                                        sc -> CourseScDTO.builder().cid(sc.getCid()).score(sc.getScore()).build()
                                ).collect(Collectors.toList()))


                ).collect(Collectors.toList());
        studentScDTOList.sort((a, b) -> (b.getAveSc().compareTo(a.getAveSc())));
//        studentScDTOList.stream().filter()

        log.info(Jackson.toString(studentScDTOList));
    }

    /**
     * ??????????????????????????????????????????????????????
     * ?????????????????????????????? ID????????? name????????????????????????????????????????????????????????????????????????????????????
     * <p>
     * ?????????>=60???????????????70-80???????????????80-90???????????????>=90
     * ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     */
    @Test
    void T14() {
        List<Sc> scList = scMapper.selectAll();
        List<Student> studentList = studentMapper.selectAll();
        List<Sc> scList1 = scList.stream().filter(sc -> sc.getCid().equals("02")).collect(Collectors.toList());
        scList1.sort((a, b) -> (b.getScore().compareTo(a.getScore())));
        Sc sc0 = scList1.get(0);
        log.info(sc0.toString());

        int count = (int) scList.stream().filter(sc -> sc.getCid().equals("02")).count();
        int size = studentList.size();
        int sum = scList.stream().filter(sc -> sc.getCid().equals("02")).mapToInt(Sc::getScore).sum();
//        Assert.isTrue(count==0,"null point");
        int aveScore = sum / count;
        log.info(sum + "\n" + count + "\n" + aveScore + "");


    }

    /**
     * ???????????????????????????????????????????????? Score ???????????????????????????
     */
    @Test
    void T15() {
        List<Student> studentList = studentMapper.selectAll();
        List<Sc> scList = scMapper.selectAll();
        List<StudentScDetailDTO> studentScDetailDTOList = studentList.stream().map(student -> StudentScDetailDTO.builder().sid(student.getSid()).aveSc(0).courseScMap(null).build())
                .peek(
                        studentScDetailDTO -> {
                            int sum = scList.stream().filter(sc -> sc.getSid().equals(studentScDetailDTO.getSid())).mapToInt(Sc::getScore).sum();
                            int count = (int) scList.stream().filter(sc -> sc.getSid().equals(studentScDetailDTO.getSid())).map(Sc::getCid).count();
                            int counts = 3;
                            if (count > 0) {
                                studentScDetailDTO.setAveSc(sum / counts);
                            }
                        }
                ).peek(
                        studentScDetailDTO -> {
                            Map<String, Integer> stringIntegerMap = scList.stream().filter(sc -> sc.getSid().equals(studentScDetailDTO.getSid())).collect(Collectors.toMap(Sc::getCid, Sc::getScore));
                            if (stringIntegerMap.size() == 3) {
                                studentScDetailDTO.setCourseScMap(stringIntegerMap);
                            } else {
                                if (!stringIntegerMap.containsKey("01")) {
                                    stringIntegerMap.put("01", 0);
                                }
                                if (!stringIntegerMap.containsKey("02")) {
                                    stringIntegerMap.put("02", 0);
                                }
                                if (!stringIntegerMap.containsKey("03")) {
                                    stringIntegerMap.put("03", 0);
                                }
                                studentScDetailDTO.setCourseScMap(stringIntegerMap);
                            }
                        }
                ).collect(Collectors.toList());

        studentScDetailDTOList.sort((a, b) -> b.getCourseScMap().get("03").toString().compareTo(a.getCourseScMap().get("03").toString()));
        log.info(Jackson.toString(studentScDetailDTOList));
    }

    /**
     * ??????????????????????????????????????????????????????????????????????????????
     */
    @Test
    void T16() {
        List<Student> studentList = studentMapper.selectAll();
        List<Sc> scList = scMapper.selectAll();
        List<StudentScDTO> studentScDTOList = studentList.stream().map(student -> StudentScDTO.builder().sid(student.getSid()).aveSc(0).courseScDTOList(null).build())
                .peek(
                        studentScDTO -> {
                            int sum = scList.stream().filter(sc -> sc.getSid().equals(studentScDTO.getSid())).mapToInt(Sc::getScore).sum();
                            int count = (int) scList.stream().filter(sc -> sc.getSid().equals(studentScDTO.getSid())).map(Sc::getCid).count();
                            int counts = 3;
                            if (count > 0) {
                                studentScDTO.setAveSc(sum / counts);
                            }
                        }
                ).peek(
                        studentScDTO ->
                                studentScDTO.setCourseScDTOList(scList.stream().filter(sc -> sc.getSid().equals(studentScDTO.getSid())).map(
                                        sc -> CourseScDTO.builder().cid(sc.getCid()).score(sc.getScore()).build()
                                ).collect(Collectors.toList()))


                ).collect(Collectors.toList());
    }

    /**
     * ?????????????????????????????????????????????????????????????????????[100-85]???[85-70]???[70-60]???[60-0] ??????????????????
     */
    @Test
    void T17() {
        List<Sc> scList = scMapper.selectAll();
        scList.stream().filter(sc -> sc.getCid().equals("03")).filter(sc -> sc.getScore() > 85).collect(Collectors.toList());
        long count = scList.stream().filter(sc -> sc.getSid().equals("03")).count();

    }

    /**
     * ????????????????????????????????????
     */
    @Test
    void T18() {
        List<Sc> scList = scMapper.selectAll();
        List<Sc> scList1 = scList.stream().filter(sc -> sc.getCid().equals("01")).collect(Collectors.toList());
        scList1.sort((a, b) -> (b.getScore().compareTo(a.getScore())));
    }

    /**
     * ???????????????????????????????????????
     */
    @Test
    void T19() {
        List<Sc> scList = scMapper.selectAll();
        long count = scList.stream().filter(sc -> sc.getCid().equals("01")).map(Sc::getSid).count();
    }

    /**
     * ??????????????????????????????????????????????????????
     */
    @Test
    void T20() {

        List<Student> studentList = studentMapper.selectAll();
        List<Sc> scList = scMapper.selectAll();

        List<Student> stList = new ArrayList<>();
        for (Student student : studentList) {
            int count = (int) scList.stream().filter(sc -> sc.getSid().equals(student.getSid())).map(Sc::getCid).count();
            if (count == 2) {
                stList.add(student);
            }

        }
    }

    /**
     * ???????????????????????????
     */
    @Test
    void T21() {
        List<Student> studentList = studentMapper.selectAll();
        List<Student> studentList1 = studentList.stream().filter(student -> student.getSsex().equals("???")).collect(Collectors.toList());

    }

    /**
     * ????????????????????????????????????????????????
     */
    @Test
    void T22() {
        List<Student> studentList = studentMapper.selectAll();
        List<Student> studentList1 = studentList.stream().filter(student -> student.getSname().contains("???")).collect(Collectors.toList());

    }

    /**
     * ??????????????????????????????????????????????????????
     */
    @Test
    void T23() {
        List<Student> students = studentMapper.selectAll();
        int count = 0;
        Set set = new HashSet<>();
        List<Student> studentList = null;
        for (Student student : students) {
            String s = student.getSname() + student.getSsex();
            set.add(s);
            ++count;
            if (count != set.size()) {
                studentList.add(student);
                --count;
            }
        }
    }

    /**
     * ?????? 1990 ?????????????????????????????? 1990 ????????????????????????
     */
    @Test
    void T24() {


    }

    /**
     * TODO
     *  ???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     */
    @Test
    void T25() {
    }

    /**
     * ?????????????????????????????? 85 ????????????????????????????????????????????????
     */
    @Test
    void T26() {
    }


    @Test
    void T27() {
    }

    @Test
    void T28() {
    }

    @Test
    void T29() {
    }

    @Test
    void T30() {
    }

    @Test
    void T31() {
    }

    @Test
    void T32() {
    }

    @Test
    void T33() {
    }

    @Test
    void T34() {
    }

    /**
     * ????????????????????????????????????????????????????????????????????????????????????
     */
    @Test
    void T35() {
    }

    @Test
    void T36() {
    }

    @Test
    void T37() {


    }

}

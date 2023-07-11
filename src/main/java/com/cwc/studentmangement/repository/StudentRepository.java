package com.cwc.studentmangement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cwc.studentmangement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	@Query("select s from Student s where s.stdName like :keyword")
	List<Student> searchBystdName(@Param("keyword") String stdName);

//	@Query(value ="select * from student where roll_no like '%roll_no%' ",nativeQuery = true)
//	 @Query(value = "select u from user u where cast(userNo as char) like :userNo%",native = true)
//	@Query(value = "select r from Student r where r.rollNo like :rollnumber",nativeQuery = true)
	
	@Query("select t from Student t where t.rollNo = ?1")
	Optional<Student>  findByRollNo(int rollNo);
	
	@Query("select t from Student t where t.rollNo = ?1")
	Optional<Student>  findByStudentRollNo(int rollNo);
	
	@Query("select u from Student u where u.section like :query")
	List<Student> findBySection(@Param("query") String  section);
	
}

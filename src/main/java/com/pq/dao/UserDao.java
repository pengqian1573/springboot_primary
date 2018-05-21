package com.pq.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pq.model.User;

/*
   1.JpaRepository支持接口规范方法名查询。意思是如果在接口中定义的查询方法符合它的命名规则，就可以不用写实现，
	Keyword 	     Sample 	                 JPQL snippet
	IsNotNull 	    findByAgeNotNull 	    ...  where x.age not null
	Like 	        findByNameLike 	        ...  where x.name like ?1
	NotLike 	    findByNameNotLike 	    ...  where x.name not like ?1
	StartingWith 	findByNameStartingWith 	...  where x.name like ?1(parameter bound with appended %)
	EndingWith 	    findByNameEndingWith 	...  where x.name like ?1(parameter bound with prepended %)
	Containing 	 	findByNameContaining 	...  where x.name like ?1(parameter bound wrapped in %)
	OrderBy 		findByAgeOrderByName 	...  where x.age = ?1 order by x.name desc
	Not 			findByNameNot 	  		...  where x.name <> ?1
	In 	    		findByAgeIn 	    	...	 where x.age in ?1
	NotIn 			findByAgeNotIn 	 		...  where x.age not in ?1
	True 			findByActiveTrue 	 	...  where x.avtive = true
	Flase 			findByActiveFalse 	 	...  where x.active = false
	And  			findByNameAndAge 	  	...  where x.name = ?1 and x.age = ?2
	Or 				findByNameOrAge 		...  where x.name = ?1 or x.age = ?2
	Between 		findBtAgeBetween 	 	...  where x.age between ?1 and ?2
	LessThan 		findByAgeLessThan 	  	... where x.age  <  ?1
	GreaterThan 	findByAgeGreaterThan 	...  where x.age > ?1
	After/Before 	... 	...
	IsNull 			findByAgeIsNull 	... 	 where x.age is null
*/
@Repository
public interface UserDao  extends JpaRepository<User, Long> {


	
	 /**
     * Find by username.
     * @param username the name
     * @return the user
     */
    User findByName(String name);
    
    
    /**
     * Find by name and user name.
     * 如果参数名为多个字母组成，请首字母大写。勿使用驼峰命名，jpa不识别驼峰
     * @param name the name
     * @param age the age
     * @return the user
     */
    User findByNameAndPassword(String name, String Password);

    /**
     * Find user.
     * User为 @Entity 的名字
     * @param idCard the idCard
     * @return the user
     */
    @Query("from User u where u.idCard=:idCard")
    List<User> findUserByIdcard(@Param("idCard") String idCard);
    
    
    
    //分页查询
    Page<User> findAll(Pageable pageable); 
    
}

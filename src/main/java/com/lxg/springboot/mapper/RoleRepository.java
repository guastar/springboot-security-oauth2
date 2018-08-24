package com.lxg.springboot.mapper;

import com.lxg.springboot.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: RoleRepository
 * @Description:
 * @Author GX
 * @Date 2018/06/11 上午 11:42
 * @Version V1.0
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}

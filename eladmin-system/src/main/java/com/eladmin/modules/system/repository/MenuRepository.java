/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.eladmin.modules.system.repository;

import com.eladmin.modules.system.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2018-12-17
 */
public interface MenuRepository extends JpaRepository<Menu, String>, JpaSpecificationExecutor<Menu> {

    /**
     * 根据菜单标题查询
     * @param title 菜单标题
     * @return /
     */
    Menu findByTitle(String title);

    /**
     * 根据组件名称查询
     * @param name 组件名称
     * @return /
     */
    Menu findByComponentName(String name);

    /**
     * 根据菜单的 PID 查询
     * @param pid /
     * @return /
     */
    List<Menu> findByPid(String pid);

    /**
     * 查询顶级菜单
     * @return /
     */
    List<Menu> findByPidIsNull();

    /**
     * 根据角色ID与菜单类型查询菜单
     * @param roleIds roleIDs
     * @param type 类型
     * @return /
     */
    @Query(value = "SELECT m.* FROM sys_menu m, sys_roles_menus r WHERE " +
            "m.id = r.menu_id AND r.role_id IN ?1 AND type != ?2 order by m.sort asc",nativeQuery = true)
    LinkedHashSet<Menu> findByRoleIdsAndTypeNot(Set<String> roleIds, int type);

    /**
     * 根据菜单类型查询菜单，用于超级管理员
     * @param type 类型
     * @return /
     */
    @Query(value = "SELECT m.* FROM sys_menu m WHERE " +
            "type != ?1 order by m.sort asc",nativeQuery = true)
    LinkedHashSet<Menu> findOfMangerByTypeNot(int type);
    /**
     * 获取节点数量
     * @param id /
     * @return /
     */
    int countByPid(String id);

    /**
     * 更新节点数目
     * @param count /
     * @param menuId /
     */
    @Modifying
    @Query(value = " update sys_menu set sub_count = ?1 where id = ?2 ",nativeQuery = true)
    void updateSubCntById(int count, String menuId);


    /**
     * 根据userId查询菜单
     * @param userId /
     * @return /
     */
    @Query(value = "SELECT m.* FROM sys_menu m, sys_roles_menus r,sys_users_roles as ur WHERE " +
            "m.id = r.menu_id AND ur.role_id = r.role_id AND ur.user_id = ?1",nativeQuery = true)
    LinkedHashSet<Menu> findByUserId(String userId);

}

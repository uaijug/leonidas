package br.com.uaijug.leonidas.model.repositories;

import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.uaijug.leonidas.model.domain.UserRole;

@Repository
@Qualifier(value = "userRoleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Query("SELECT ur FROM br.com.geden.gedencore.model.domain.UserRole ur WHERE ur.id = :id")
    Set<UserRole> findRoleNameByUserId(@Param("id") Long id);

    // @Query( "select o from MyObject o where inventoryId in :ids" )
    // findByInventoryIds(@Param("ids") List<Long> inventoryIdList);
}
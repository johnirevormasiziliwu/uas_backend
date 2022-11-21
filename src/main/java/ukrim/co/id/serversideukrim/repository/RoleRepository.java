/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukrim.co.id.serversideukrim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukrim.co.id.serversideukrim.model.Role;

/**
 *
 * @author MSI-JO
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}

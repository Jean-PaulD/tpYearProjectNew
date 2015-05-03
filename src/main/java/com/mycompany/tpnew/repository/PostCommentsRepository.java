/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.repository;

import com.mycompany.tpnew.domain.PostComments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JEAN-PAUL
 */
public interface PostCommentsRepository extends JpaRepository <PostComments, Long>{
    
}

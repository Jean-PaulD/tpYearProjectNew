/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.config.factory;

import com.mycompany.tpnew.domain.Complaints;

/**
 *
 * @author JEAN-PAUL
 */
public class ComplaintsFactory {
    public static Complaints createComplaint(String username,String timestamp, String complaint){

        Complaints complaints = new Complaints
                .Builder(username)
                .complaint(complaint)
                .timeStamp(timestamp)
                .build();
        
        return complaints;
    }
}

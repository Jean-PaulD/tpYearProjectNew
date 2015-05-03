/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tpnew.config.factory;

import com.mycompany.tpnew.domain.NoticeBoard;

/**
 *
 * @author JEAN-PAUL
 */
public class NoticeBoardFactory {
    public static NoticeBoard createNoticeBoard(String username){

        NoticeBoard noticeBoard = new NoticeBoard
                .Builder(username)
                .build();
                
                
        return noticeBoard;
    }
}

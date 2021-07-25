package com.hive.ansj.entity

import javax.persistence.*

@Entity
@Table(name="TBL_BOARD", schema="PUBLIC")
class Board (
    @Id
    @Column(name="BNO")
    var bno:Int,
    @Column(name="TITLE")
    var title:String,
    @Column(name="CONTENT")
    var content:String,

    @OneToMany(mappedBy = "bno", fetch = FetchType.LAZY)//mappedBy는 클래스 프로퍼티명과 동일해야 하고..
    var replies: MutableList<Replies>?
){
    override fun toString(): String{
        return "Board[bno=$bno, title=$title, content=$content, replies=$replies]"
    }
}
//{
//    constructor(bno: Int, title: String, content: String) : this(bno, title, content, null)
//
//    override fun toString(): String {
//        return "Board[bno=$bno, title=$title, content=$content, replies=$replies]"
//    }
//}
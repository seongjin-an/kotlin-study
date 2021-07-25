package com.hive.ansj.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "TBL_REPLIES", schema = "PUBLIC")
class Replies (
    @Id
    @Column(name = "RNO")
    var rno: Int,
    @Column(name = "REPLY")
    var reply: String,
    @Column(name = "BNO")
    var bno: Int,
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BNO", referencedColumnName = "BNO", insertable = false, updatable = false)
    var board: Board?
){
    override fun toString(): String {
        return super.toString()
    }
}
//{
//    constructor(rno: Int, reply: String, bno: Int) : this(rno, reply, bno, null)
//
//    override fun toString(): String {
//        return "Replies[rno=$rno, reply=$reply, bno=$bno]"
//    }
//}
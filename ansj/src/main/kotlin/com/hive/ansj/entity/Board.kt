package com.hive.ansj.entity

import javax.persistence.*

@Entity
@Table(name="TBL_BOARD", schema="PUBLIC")
class Board (
    @Id
    @Column(name="BNO")
    var bno:Int,
    @Column(name="TITLE")
    var Title:String,
    @Column(name="CONTENT")
    var content:String,

    @OneToMany(mappedBy = "BNO", fetch = FetchType.LAZY)
    var replies: MutableList<Replies>?

)
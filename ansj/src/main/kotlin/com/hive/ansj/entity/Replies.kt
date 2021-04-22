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
    @JoinColumn(name = "BNO")
    var board: Board
)
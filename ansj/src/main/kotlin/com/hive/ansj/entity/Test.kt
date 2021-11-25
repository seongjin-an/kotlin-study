package com.hive.ansj.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "TEST_TABLE")
class Test (
    @Id
    @Column(name="NO")
    var no: Int
)
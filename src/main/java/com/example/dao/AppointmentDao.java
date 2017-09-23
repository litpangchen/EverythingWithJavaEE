package com.example.dao;

import org.apache.ibatis.annotations.Param;

public interface AppointmentDao {
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);
}

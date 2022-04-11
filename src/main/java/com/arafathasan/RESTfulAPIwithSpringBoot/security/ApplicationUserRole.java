package com.arafathasan.RESTfulAPIwithSpringBoot.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.arafathasan.RESTfulAPIwithSpringBoot.security.ApplicationUserPermission.*;


public enum ApplicationUserRole {
//    STUDENT(Sets.newHashSet(STUDENT_WRITE)),
    STUDENT(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));

    private final Set<ApplicationUserPermission> permissionSet;

    ApplicationUserRole(Set<ApplicationUserPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }
}

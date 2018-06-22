package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsUser is a Querydsl query type for CbhsUser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsUser extends EntityPathBase<CbhsUser> {

    private static final long serialVersionUID = 2144303783L;

    public static final QCbhsUser cbhsUser = new QCbhsUser("cbhsUser");

    public final StringPath avatar = createString("avatar");

    public final NumberPath<Integer> avatarOid = createNumber("avatarOid", Integer.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final BooleanPath isAdmin = createBoolean("isAdmin");

    public final BooleanPath isAllDept = createBoolean("isAllDept");

    public final StringPath menuids = createString("menuids");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath roleids = createString("roleids");

    public final StringPath roleNames = createString("roleNames");

    public final BooleanPath sex = createBoolean("sex");

    public final BooleanPath status = createBoolean("status");

    public QCbhsUser(String variable) {
        super(CbhsUser.class, forVariable(variable));
    }

    public QCbhsUser(Path<? extends CbhsUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsUser(PathMetadata metadata) {
        super(CbhsUser.class, metadata);
    }

}


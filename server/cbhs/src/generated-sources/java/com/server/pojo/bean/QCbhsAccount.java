package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCbhsAccount is a Querydsl query type for CbhsAccount
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsAccount extends EntityPathBase<CbhsAccount> {

    private static final long serialVersionUID = 875314641L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCbhsAccount cbhsAccount = new QCbhsAccount("cbhsAccount");

    public final StringPath account = createString("account");

    public final StringPath accountKey = createString("accountKey");

    public final StringPath password = createString("password");

    public final StringPath ryToken = createString("ryToken");

    public final StringPath token = createString("token");

    public final QCbhsUser user;

    public final StringPath webtoken = createString("webtoken");

    public QCbhsAccount(String variable) {
        this(CbhsAccount.class, forVariable(variable), INITS);
    }

    public QCbhsAccount(Path<? extends CbhsAccount> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCbhsAccount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCbhsAccount(PathMetadata metadata, PathInits inits) {
        this(CbhsAccount.class, metadata, inits);
    }

    public QCbhsAccount(Class<? extends CbhsAccount> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QCbhsUser(forProperty("user")) : null;
    }

}


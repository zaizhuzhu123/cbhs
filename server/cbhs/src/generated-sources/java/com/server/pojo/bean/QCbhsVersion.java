package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsVersion is a Querydsl query type for CbhsVersion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsVersion extends EntityPathBase<CbhsVersion> {

    private static final long serialVersionUID = -1890725764L;

    public static final QCbhsVersion cbhsVersion = new QCbhsVersion("cbhsVersion");

    public final NumberPath<Integer> fileOid = createNumber("fileOid", Integer.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath pushAlert = createString("pushAlert");

    public final StringPath pushtitle = createString("pushtitle");

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> versionCode = createNumber("versionCode", Integer.class);

    public QCbhsVersion(String variable) {
        super(CbhsVersion.class, forVariable(variable));
    }

    public QCbhsVersion(Path<? extends CbhsVersion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsVersion(PathMetadata metadata) {
        super(CbhsVersion.class, metadata);
    }

}


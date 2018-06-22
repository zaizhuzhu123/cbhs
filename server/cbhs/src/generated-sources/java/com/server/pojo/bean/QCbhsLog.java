package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsLog is a Querydsl query type for CbhsLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsLog extends EntityPathBase<CbhsLog> {

    private static final long serialVersionUID = 1038993640L;

    public static final QCbhsLog cbhsLog = new QCbhsLog("cbhsLog");

    public final StringPath ip = createString("ip");

    public final StringPath method = createString("method");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final StringPath paramBody = createString("paramBody");

    public final StringPath paramQuery = createString("paramQuery");

    public final StringPath time = createString("time");

    public final NumberPath<Long> timeUse = createNumber("timeUse", Long.class);

    public final StringPath url = createString("url");

    public final NumberPath<Integer> userOid = createNumber("userOid", Integer.class);

    public QCbhsLog(String variable) {
        super(CbhsLog.class, forVariable(variable));
    }

    public QCbhsLog(Path<? extends CbhsLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsLog(PathMetadata metadata) {
        super(CbhsLog.class, metadata);
    }

}


package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCbhsReim is a Querydsl query type for CbhsReim
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsReim extends EntityPathBase<CbhsReim> {

    private static final long serialVersionUID = 2144201075L;

    public static final QCbhsReim cbhsReim = new QCbhsReim("cbhsReim");

    public final NumberPath<Integer> attachmentCount = createNumber("attachmentCount", Integer.class);

    public final StringPath cwPersonName = createString("cwPersonName");

    public final NumberPath<java.math.BigDecimal> cwTotal = createNumber("cwTotal", java.math.BigDecimal.class);

    public final StringPath dateStr = createString("dateStr");

    public final NumberPath<Long> dateTimeStamp = createNumber("dateTimeStamp", Long.class);

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final NumberPath<Integer> examOid = createNumber("examOid", Integer.class);

    public final StringPath monthStr = createString("monthStr");

    public final NumberPath<Long> monthTimeStamp = createNumber("monthTimeStamp", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final StringPath orderOid = createString("orderOid");

    public final NumberPath<Integer> process = createNumber("process", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final NumberPath<Integer> shStatus = createNumber("shStatus", Integer.class);

    public final ListPath<CbhsReimTerm, QCbhsReimTerm> terms = this.<CbhsReimTerm, QCbhsReimTerm>createList("terms", CbhsReimTerm.class, QCbhsReimTerm.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public QCbhsReim(String variable) {
        super(CbhsReim.class, forVariable(variable));
    }

    public QCbhsReim(Path<? extends CbhsReim> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsReim(PathMetadata metadata) {
        super(CbhsReim.class, metadata);
    }

}


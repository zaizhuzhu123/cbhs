package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsCbExaminerDetails is a Querydsl query type for CbhsCbExaminerDetails
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsCbExaminerDetails extends EntityPathBase<CbhsCbExaminerDetails> {

    private static final long serialVersionUID = -1938455530L;

    public static final QCbhsCbExaminerDetails cbhsCbExaminerDetails = new QCbhsCbExaminerDetails("cbhsCbExaminerDetails");

    public final NumberPath<Integer> examOid = createNumber("examOid", Integer.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final StringPath shRemark = createString("shRemark");

    public final NumberPath<Integer> shStatus = createNumber("shStatus", Integer.class);

    public final StringPath shUName = createString("shUName");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QCbhsCbExaminerDetails(String variable) {
        super(CbhsCbExaminerDetails.class, forVariable(variable));
    }

    public QCbhsCbExaminerDetails(Path<? extends CbhsCbExaminerDetails> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsCbExaminerDetails(PathMetadata metadata) {
        super(CbhsCbExaminerDetails.class, metadata);
    }

}


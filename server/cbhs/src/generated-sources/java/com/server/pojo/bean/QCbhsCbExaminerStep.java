package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsCbExaminerStep is a Querydsl query type for CbhsCbExaminerStep
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsCbExaminerStep extends EntityPathBase<CbhsCbExaminerStep> {

    private static final long serialVersionUID = -263002760L;

    public static final QCbhsCbExaminerStep cbhsCbExaminerStep = new QCbhsCbExaminerStep("cbhsCbExaminerStep");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> shorder = createNumber("shorder", Integer.class);

    public final StringPath shPersonName = createString("shPersonName");

    public final NumberPath<Integer> shPersonOid = createNumber("shPersonOid", Integer.class);

    public final NumberPath<Integer> stepStatus = createNumber("stepStatus", Integer.class);

    public final NumberPath<Integer> taskOid = createNumber("taskOid", Integer.class);

    public QCbhsCbExaminerStep(String variable) {
        super(CbhsCbExaminerStep.class, forVariable(variable));
    }

    public QCbhsCbExaminerStep(Path<? extends CbhsCbExaminerStep> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsCbExaminerStep(PathMetadata metadata) {
        super(CbhsCbExaminerStep.class, metadata);
    }

}


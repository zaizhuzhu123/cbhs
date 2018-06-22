package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsCbExaminer is a Querydsl query type for CbhsCbExaminer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsCbExaminer extends EntityPathBase<CbhsCbExaminer> {

    private static final long serialVersionUID = 1245614220L;

    public static final QCbhsCbExaminer cbhsCbExaminer = new QCbhsCbExaminer("cbhsCbExaminer");

    public final StringPath alert = createString("alert");

    public final NumberPath<Integer> cbOid = createNumber("cbOid", Integer.class);

    public final NumberPath<Integer> completeState = createNumber("completeState", Integer.class);

    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    public final StringPath createTimeStr = createString("createTimeStr");

    public final StringPath deptName = createString("deptName");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final StringPath extStr = createString("extStr");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final StringPath personName = createString("personName");

    public final NumberPath<Integer> personOid = createNumber("personOid", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public final NumberPath<Integer> shorder = createNumber("shorder", Integer.class);

    public final NumberPath<Integer> shPersonOid = createNumber("shPersonOid", Integer.class);

    public final StringPath title = createString("title");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QCbhsCbExaminer(String variable) {
        super(CbhsCbExaminer.class, forVariable(variable));
    }

    public QCbhsCbExaminer(Path<? extends CbhsCbExaminer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsCbExaminer(PathMetadata metadata) {
        super(CbhsCbExaminer.class, metadata);
    }

}


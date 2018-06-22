package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsCbExaminerRule is a Querydsl query type for CbhsCbExaminerRule
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsCbExaminerRule extends EntityPathBase<CbhsCbExaminerRule> {

    private static final long serialVersionUID = -263031384L;

    public static final QCbhsCbExaminerRule cbhsCbExaminerRule = new QCbhsCbExaminerRule("cbhsCbExaminerRule");

    public final StringPath deptNames = createString("deptNames");

    public final NumberPath<Integer> deptOid = createNumber("deptOid", Integer.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final StringPath personName1 = createString("personName1");

    public final StringPath personName2 = createString("personName2");

    public final NumberPath<Integer> personOid1 = createNumber("personOid1", Integer.class);

    public final NumberPath<Integer> personOid2 = createNumber("personOid2", Integer.class);

    public final NumberPath<Integer> projectOid = createNumber("projectOid", Integer.class);

    public QCbhsCbExaminerRule(String variable) {
        super(CbhsCbExaminerRule.class, forVariable(variable));
    }

    public QCbhsCbExaminerRule(Path<? extends CbhsCbExaminerRule> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsCbExaminerRule(PathMetadata metadata) {
        super(CbhsCbExaminerRule.class, metadata);
    }

}


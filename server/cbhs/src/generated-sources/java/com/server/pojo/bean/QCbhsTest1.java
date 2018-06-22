package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsTest1 is a Querydsl query type for CbhsTest1
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsTest1 extends EntityPathBase<CbhsTest1> {

    private static final long serialVersionUID = 2047580803L;

    public static final QCbhsTest1 cbhsTest1 = new QCbhsTest1("cbhsTest1");

    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final StringPath test1name = createString("test1name");

    public final NumberPath<Long> updateTime = createNumber("updateTime", Long.class);

    public QCbhsTest1(String variable) {
        super(CbhsTest1.class, forVariable(variable));
    }

    public QCbhsTest1(Path<? extends CbhsTest1> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsTest1(PathMetadata metadata) {
        super(CbhsTest1.class, metadata);
    }

}


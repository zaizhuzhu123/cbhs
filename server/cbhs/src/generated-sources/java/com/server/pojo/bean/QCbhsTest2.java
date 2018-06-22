package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsTest2 is a Querydsl query type for CbhsTest2
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsTest2 extends EntityPathBase<CbhsTest2> {

    private static final long serialVersionUID = 2047580804L;

    public static final QCbhsTest2 cbhsTest2 = new QCbhsTest2("cbhsTest2");

    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final StringPath test2name = createString("test2name");

    public final NumberPath<Long> updateTime = createNumber("updateTime", Long.class);

    public QCbhsTest2(String variable) {
        super(CbhsTest2.class, forVariable(variable));
    }

    public QCbhsTest2(Path<? extends CbhsTest2> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsTest2(PathMetadata metadata) {
        super(CbhsTest2.class, metadata);
    }

}


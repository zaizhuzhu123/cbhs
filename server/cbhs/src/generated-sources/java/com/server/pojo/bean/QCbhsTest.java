package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCbhsTest is a Querydsl query type for CbhsTest
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsTest extends EntityPathBase<CbhsTest> {

    private static final long serialVersionUID = 2144260974L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCbhsTest cbhsTest = new QCbhsTest("cbhsTest");

    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final QCbhsTest1 test1;

    public final NumberPath<Long> updateTime = createNumber("updateTime", Long.class);

    public QCbhsTest(String variable) {
        this(CbhsTest.class, forVariable(variable), INITS);
    }

    public QCbhsTest(Path<? extends CbhsTest> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCbhsTest(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCbhsTest(PathMetadata metadata, PathInits inits) {
        this(CbhsTest.class, metadata, inits);
    }

    public QCbhsTest(Class<? extends CbhsTest> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.test1 = inits.isInitialized("test1") ? new QCbhsTest1(forProperty("test1")) : null;
    }

}


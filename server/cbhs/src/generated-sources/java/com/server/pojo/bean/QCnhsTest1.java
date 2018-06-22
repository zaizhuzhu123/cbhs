package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCnhsTest1 is a Querydsl query type for CnhsTest1
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCnhsTest1 extends EntityPathBase<CnhsTest1> {

    private static final long serialVersionUID = 1486468343L;

    public static final QCnhsTest1 cnhsTest1 = new QCnhsTest1("cnhsTest1");

    public final NumberPath<Long> createTime = createNumber("createTime", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final StringPath test1name = createString("test1name");

    public final NumberPath<Long> updateTime = createNumber("updateTime", Long.class);

    public QCnhsTest1(String variable) {
        super(CnhsTest1.class, forVariable(variable));
    }

    public QCnhsTest1(Path<? extends CnhsTest1> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCnhsTest1(PathMetadata metadata) {
        super(CnhsTest1.class, metadata);
    }

}


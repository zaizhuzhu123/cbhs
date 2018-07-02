package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsContacts is a Querydsl query type for CbhsContacts
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsContacts extends EntityPathBase<CbhsContacts> {

    private static final long serialVersionUID = -1360322257L;

    public static final QCbhsContacts cbhsContacts = new QCbhsContacts("cbhsContacts");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final StringPath phone = createString("phone");

    public final StringPath post = createString("post");

    public QCbhsContacts(String variable) {
        super(CbhsContacts.class, forVariable(variable));
    }

    public QCbhsContacts(Path<? extends CbhsContacts> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsContacts(PathMetadata metadata) {
        super(CbhsContacts.class, metadata);
    }

}


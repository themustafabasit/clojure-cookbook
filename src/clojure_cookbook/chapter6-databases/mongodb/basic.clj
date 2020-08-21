(ns clojure-cookbook.chapter6-databases.mongodb.basic
  (:require [monger.core :as mongo]
            [monger.collection :as coll]))

(mongo/connect )
;; => #object[com.mongodb.MongoClient 0x478b1012 "Mongo{options=MongoClientOptions{description='null', applicationName='null', compressors='[]', readPreference=primary, writeConcern=WriteConcern{w=null, wTimeout=null ms, fsync=null, journal=null, retryWrites=false, readConcern=com.mongodb.ReadConcern@0, codecRegistry=org.bson.codecs.configuration.ProvidersCodecRegistry@2ffb0a28, serverSelector=null, clusterListeners=[], commandListeners=[], minConnectionsPerHost=0, maxConnectionsPerHost=100, threadsAllowedToBlockForConnectionMultiplier=5, serverSelectionTimeout=30000, maxWaitTime=120000, maxConnectionIdleTime=0, maxConnectionLifeTime=0, connectTimeout=10000, socketTimeout=0, socketKeepAlive=true, sslEnabled=false, sslInvalidHostNamesAllowed=false, sslContext=null, alwaysUseMBeans=false, heartbeatFrequency=10000, minHeartbeatFrequency=500, heartbeatConnectTimeout=20000, heartbeatSocketTimeout=20000, localThreshold=15, requiredReplicaSetName='null', dbDecoderFactory=com.mongodb.DefaultDBDecoder$1@77c8ad02, dbEncoderFactory=com.mongodb.DefaultDBEncoder$1@3b352095, socketFactory=null, cursorFinalizerEnabled=true, connectionPoolSettings=ConnectionPoolSettings{maxSize=100, minSize=0, maxWaitQueueSize=500, maxWaitTimeMS=120000, maxConnectionLifeTimeMS=0, maxConnectionIdleTimeMS=0, maintenanceInitialDelayMS=0, maintenanceFrequencyMS=60000, connectionPoolListeners=[]}, socketSettings=SocketSettings{connectTimeoutMS=10000, readTimeoutMS=0, keepAlive=true, receiveBufferSize=0, sendBufferSize=0}, serverSettings=ServerSettings{heartbeatFrequencyMS=10000, minHeartbeatFrequencyMS=500, serverListeners='[]', serverMonitorListeners='[]'}, heartbeatSocketSettings=SocketSettings{connectTimeoutMS=20000, readTimeoutMS=20000, keepAlive=true, receiveBufferSize=0, sendBufferSize=0}}}"]

(mongo/connect {:host "localhost"})
;; => #object[com.mongodb.MongoClient 0x711d70da "Mongo{options=MongoClientOptions{description='null', applicationName='null', compressors='[]', readPreference=primary, writeConcern=WriteConcern{w=null, wTimeout=null ms, fsync=null, journal=null, retryWrites=false, readConcern=com.mongodb.ReadConcern@0, codecRegistry=org.bson.codecs.configuration.ProvidersCodecRegistry@2ffb0a28, serverSelector=null, clusterListeners=[], commandListeners=[], minConnectionsPerHost=0, maxConnectionsPerHost=100, threadsAllowedToBlockForConnectionMultiplier=5, serverSelectionTimeout=30000, maxWaitTime=120000, maxConnectionIdleTime=0, maxConnectionLifeTime=0, connectTimeout=10000, socketTimeout=0, socketKeepAlive=true, sslEnabled=false, sslInvalidHostNamesAllowed=false, sslContext=null, alwaysUseMBeans=false, heartbeatFrequency=10000, minHeartbeatFrequency=500, heartbeatConnectTimeout=20000, heartbeatSocketTimeout=20000, localThreshold=15, requiredReplicaSetName='null', dbDecoderFactory=com.mongodb.DefaultDBDecoder$1@77c8ad02, dbEncoderFactory=com.mongodb.DefaultDBEncoder$1@3b352095, socketFactory=null, cursorFinalizerEnabled=true, connectionPoolSettings=ConnectionPoolSettings{maxSize=100, minSize=0, maxWaitQueueSize=500, maxWaitTimeMS=120000, maxConnectionLifeTimeMS=0, maxConnectionIdleTimeMS=0, maintenanceInitialDelayMS=0, maintenanceFrequencyMS=60000, connectionPoolListeners=[]}, socketSettings=SocketSettings{connectTimeoutMS=10000, readTimeoutMS=0, keepAlive=true, receiveBufferSize=0, sendBufferSize=0}, serverSettings=ServerSettings{heartbeatFrequencyMS=10000, minHeartbeatFrequencyMS=500, serverListeners='[]', serverMonitorListeners='[]'}, heartbeatSocketSettings=SocketSettings{connectTimeoutMS=20000, readTimeoutMS=20000, keepAlive=true, receiveBufferSize=0, sendBufferSize=0}}}"]

(mongo/connect {:port 27017})
;; => #object[com.mongodb.MongoClient 0x41bc9128 "Mongo{options=MongoClientOptions{description='null', applicationName='null', compressors='[]', readPreference=primary, writeConcern=WriteConcern{w=null, wTimeout=null ms, fsync=null, journal=null, retryWrites=false, readConcern=com.mongodb.ReadConcern@0, codecRegistry=org.bson.codecs.configuration.ProvidersCodecRegistry@2ffb0a28, serverSelector=null, clusterListeners=[], commandListeners=[], minConnectionsPerHost=0, maxConnectionsPerHost=100, threadsAllowedToBlockForConnectionMultiplier=5, serverSelectionTimeout=30000, maxWaitTime=120000, maxConnectionIdleTime=0, maxConnectionLifeTime=0, connectTimeout=10000, socketTimeout=0, socketKeepAlive=true, sslEnabled=false, sslInvalidHostNamesAllowed=false, sslContext=null, alwaysUseMBeans=false, heartbeatFrequency=10000, minHeartbeatFrequency=500, heartbeatConnectTimeout=20000, heartbeatSocketTimeout=20000, localThreshold=15, requiredReplicaSetName='null', dbDecoderFactory=com.mongodb.DefaultDBDecoder$1@77c8ad02, dbEncoderFactory=com.mongodb.DefaultDBEncoder$1@3b352095, socketFactory=null, cursorFinalizerEnabled=true, connectionPoolSettings=ConnectionPoolSettings{maxSize=100, minSize=0, maxWaitQueueSize=500, maxWaitTimeMS=120000, maxConnectionLifeTimeMS=0, maxConnectionIdleTimeMS=0, maintenanceInitialDelayMS=0, maintenanceFrequencyMS=60000, connectionPoolListeners=[]}, socketSettings=SocketSettings{connectTimeoutMS=10000, readTimeoutMS=0, keepAlive=true, receiveBufferSize=0, sendBufferSize=0}, serverSettings=ServerSettings{heartbeatFrequencyMS=10000, minHeartbeatFrequencyMS=500, serverListeners='[]', serverMonitorListeners='[]'}, heartbeatSocketSettings=SocketSettings{connectTimeoutMS=20000, readTimeoutMS=20000, keepAlive=true, receiveBufferSize=0, sendBufferSize=0}}}"]

(mongo/connect {:host "localhost"
                :port 27017})
;; => #object[com.mongodb.MongoClient 0x36bb196a "Mongo{options=MongoClientOptions{description='null', applicationName='null', compressors='[]', readPreference=primary, writeConcern=WriteConcern{w=null, wTimeout=null ms, fsync=null, journal=null, retryWrites=false, readConcern=com.mongodb.ReadConcern@0, codecRegistry=org.bson.codecs.configuration.ProvidersCodecRegistry@2ffb0a28, serverSelector=null, clusterListeners=[], commandListeners=[], minConnectionsPerHost=0, maxConnectionsPerHost=100, threadsAllowedToBlockForConnectionMultiplier=5, serverSelectionTimeout=30000, maxWaitTime=120000, maxConnectionIdleTime=0, maxConnectionLifeTime=0, connectTimeout=10000, socketTimeout=0, socketKeepAlive=true, sslEnabled=false, sslInvalidHostNamesAllowed=false, sslContext=null, alwaysUseMBeans=false, heartbeatFrequency=10000, minHeartbeatFrequency=500, heartbeatConnectTimeout=20000, heartbeatSocketTimeout=20000, localThreshold=15, requiredReplicaSetName='null', dbDecoderFactory=com.mongodb.DefaultDBDecoder$1@77c8ad02, dbEncoderFactory=com.mongodb.DefaultDBEncoder$1@3b352095, socketFactory=null, cursorFinalizerEnabled=true, connectionPoolSettings=ConnectionPoolSettings{maxSize=100, minSize=0, maxWaitQueueSize=500, maxWaitTimeMS=120000, maxConnectionLifeTimeMS=0, maxConnectionIdleTimeMS=0, maintenanceInitialDelayMS=0, maintenanceFrequencyMS=60000, connectionPoolListeners=[]}, socketSettings=SocketSettings{connectTimeoutMS=10000, readTimeoutMS=0, keepAlive=true, receiveBufferSize=0, sendBufferSize=0}, serverSettings=ServerSettings{heartbeatFrequencyMS=10000, minHeartbeatFrequencyMS=500, serverListeners='[]', serverMonitorListeners='[]'}, heartbeatSocketSettings=SocketSettings{connectTimeoutMS=20000, readTimeoutMS=20000, keepAlive=true, receiveBufferSize=0, sendBufferSize=0}}}"]

(mongo/get-db
 (mongo/connect)
 "mydb")
;; => #object[com.mongodb.DB 0x771f0c4c "DB{name='mydb'}"]


(def conn (mongo/connect {:host "localhost" :port 27017}))
(def db-name "mydb")
(def db (mongo/get-db conn db-name))
(def db-coll "students")

(coll/insert-and-return db db-coll {:name "Mustafa Basit"
                                    :msg "success!"})
;; => {:_id #object[org.bson.types.ObjectId 0x5a149cf3 "5f3f6958799d903c57513919"], :name "Mustafa Basit", :msg "success!"}

(coll/find db db-coll)
;; => #object[com.mongodb.DBCursor 0x4db752f7 "DBCursor{collection=DBCollection{database=DB{name='mydb'}, name='students'}, find=com.mongodb.client.model.DBCollectionFindOptions@22ba7b5c}"]

(coll/find-one db db-coll {:name "Mustafa Basit"})
;; => {"_id" #object[org.bson.types.ObjectId 0x5c04d081 "5f3f66f9799d903c57513916"], "name" "Mustafa Basit", "msg" "success!"}

(coll/find-maps db db-coll)
;; => ({:_id #object[org.bson.types.ObjectId 0x62b0cceb "5f3f66f9799d903c57513916"], :name "Mustafa Basit", :msg "success!"}
;;     {:_id #object[org.bson.types.ObjectId 0x7b1ab417 "5f3f694e799d903c57513918"], :name "Mustafa Basit", :msg "success!"}
;;     {:_id #object[org.bson.types.ObjectId 0x14320948 "5f3f6958799d903c57513919"], :name "Mustafa Basit", :msg "success!"})

(coll/insert db db-coll {:name "Wasit Shafi"
                         :msg "success!"})
;; => #object[com.mongodb.WriteResult 0x3f4cd7af "WriteResult{n=0, updateOfExisting=false, upsertedId=null}"]

(coll/find-one-as-map db db-coll {:name "Wasit Shafi"})
;; => {:_id #object[org.bson.types.ObjectId 0x4be6504f "5f3f6ded799d903c5751391a"], :name "Wasit Shafi", :msg "success!"}

(mongo/disconnect conn)
;; => nil

(coll/find-one-as-map db db-coll {:name "Wasit Shafi"})
;; Execution error (IllegalStateException) at com.mongodb.assertions.Assertions/isTrue (Assertions.java:70).
;; state should be: open


;; stop and switch to clojurewerkzs monger official doc
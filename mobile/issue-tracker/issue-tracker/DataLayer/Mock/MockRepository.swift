//
//  RepositoryStub.swift
//  issue-tracker
//
//  Created by HOONHA CHOI on 2021/06/15.
//

import Foundation
import Combine

final class MockRepository: NetworkEngine {

    var error: NetworkError?

    func requestUserAuth(to code: Data) -> AnyPublisher<[String: String], NetworkError> {
        if let error = error {
            return Fail<[String: String], NetworkError>(error: error).eraseToAnyPublisher()
        } else {
            return Just(["testToken": "testString"])
                .setFailureType(to: NetworkError.self)
                .eraseToAnyPublisher()
        }
    }
}

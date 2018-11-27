

trait BasicMultiNodeSpec extends MultiNodeSpecCallbacks
                          with FlatSpecLike
                          with MustMatchers
                          with BeforeAndAfterAll {
  override def beforeAll = multiNodeSpecBeforeAll()

  override def afterAll = multiNodeSpecAfterAll()
}
package com.danielasfregola.twitter4s.http.clients.rest.statuses.parameters

import com.danielasfregola.twitter4s.entities.enums.TweetMode
import org.specs2.mutable.SpecificationLike

class HomeTimelineParametersSpec extends SpecificationLike {

  "HomeTimelineParameters" should {
    "correctly represents each field as the respective request parameter" in {
      HomeTimelineParameters(
        count = 20, since_id = Some(100L), max_id = Some(200L), trim_user = true, exclude_replies = true,
        contributor_details = true, include_entities = true, tweet_mode = Some(TweetMode.Extended)
      ).toString shouldEqual
        """contributor_details=true&
          |count=20&
          |exclude_replies=true&
          |include_entities=true&
          |max_id=200&
          |since_id=100&
          |trim_user=true&
          |tweet_mode=extended""".stripMargin.replace("\n", "")
    }
    "doesn't provide request parameter if the respective optional field is empty" in {
      HomeTimelineParameters(
        count = 20, since_id = None, max_id = None, trim_user = false, exclude_replies = false,
        contributor_details = false, include_entities = false, tweet_mode = None
      ).toString shouldEqual
        """contributor_details=false&
          |count=20&
          |exclude_replies=false&
          |include_entities=false&
          |trim_user=false""".stripMargin.replace("\n", "")
    }
  }

}

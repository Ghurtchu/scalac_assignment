package model


case class Owner(
                  login: Option[String],
                  id: Option[Double],
                  node_id: Option[String],
                  avatar_url: Option[String],
                  gravatar_id: Option[String],
                  url: Option[String],
                  html_url: Option[String],
                  followers_url: Option[String],
                  following_url: Option[String],
                  gists_url: Option[String],
                  starred_url: Option[String],
                  subscriptions_url: Option[String],
                  organizations_url: Option[String],
                  repos_url: Option[String],
                  events_url: Option[String],
                  received_events_url: Option[String],
                  `type`: Option[String],
                  site_admin: Option[Boolean]
                )

case class License(
                    key: Option[String],
                    name: Option[String],
                    spdx_id: Option[String],
                    url: Option[String],
                    node_id: Option[String]
                  )

case class Permissions(
                        admin: Option[Boolean],
                        maintain: Option[Boolean],
                        push: Option[Boolean],
                        triage: Option[Boolean],
                        pull: Option[Boolean]
                      )

case class Repository(
                           id: Option[Double],
                           node_id: Option[String],
                           name: Option[String],
                           full_name: Option[String],
                           `private`: Option[Boolean],
                           owner: Option[Owner],
                           html_url: Option[String],
                           description: Option[String],
                           fork: Option[Boolean],
                           url: Option[String],
                           forks_url: Option[String],
                           keys_url: Option[String],
                           collaborators_url: Option[String],
                           teams_url: Option[String],
                           hooks_url: Option[String],
                           issue_events_url: Option[String],
                           events_url: Option[String],
                           assignees_url: Option[String],
                           branches_url: Option[String],
                           tags_url: Option[String],
                           blobs_url: Option[String],
                           git_tags_url: Option[String],
                           git_refs_url: Option[String],
                           trees_url: Option[String],
                           statuses_url: Option[String],
                           languages_url: Option[String],
                           stargazers_url: Option[String],
                           contributors_url: Option[String],
                           subscribers_url: Option[String],
                           subscription_url: Option[String],
                           commits_url: Option[String],
                           git_commits_url: Option[String],
                           comments_url: Option[String],
                           issue_comment_url: Option[String],
                           contents_url: Option[String],
                           compare_url: Option[String],
                           merges_url: Option[String],
                           archive_url: Option[String],
                           downloads_url: Option[String],
                           issues_url: Option[String],
                           pulls_url: Option[String],
                           milestones_url: Option[String],
                           notifications_url: Option[String],
                           labels_url: Option[String],
                           releases_url: Option[String],
                           deployments_url: Option[String],
                           created_at: Option[String],
                           updated_at: Option[String],
                           pushed_at: Option[String],
                           git_url: Option[String],
                           ssh_url: Option[String],
                           clone_url: Option[String],
                           svn_url: Option[String],
                           homepage: Option[String],
                           size: Option[Double],
                           stargazers_count: Option[Double],
                           watchers_count: Option[Double],
                           language: Option[String],
                           has_issues: Option[Boolean],
                           has_projects: Option[Boolean],
                           has_downloads: Option[Boolean],
                           has_wiki: Option[Boolean],
                           has_pages: Option[Boolean],
                           forks_count: Option[Double],
                           mirror_url: Option[String],
                           archived: Option[Boolean],
                           disabled: Option[Boolean],
                           open_issues_count: Option[Double],
                           license: Option[License],
                           allow_forking: Option[Boolean],
                           is_template: Option[Boolean],
                           topics: Option[List[String]],
                           visibility: Option[String],
                           forks: Option[Double],
                           open_issues: Option[Double],
                           watchers: Option[Double],
                           default_branch: Option[String],
                           permissions: Option[Permissions]
                         )

case class Contributor(
                           login: Option[String],
                           id: Option[Double],
                           node_id: Option[String],
                           avatar_url: Option[String],
                           gravatar_id: Option[String],
                           url: Option[String],
                           html_url: Option[String],
                           followers_url: Option[String],
                           following_url: Option[String],
                           gists_url: Option[String],
                           starred_url: Option[String],
                           subscriptions_url: Option[String],
                           organizations_url: Option[String],
                           repos_url: Option[String],
                           events_url: Option[String],
                           received_events_url: Option[String],
                           `type`: Option[String],
                           site_admin: Option[Boolean],
                           contributions: Option[Double]
                         )

case class Result (
                  name: String,
                  contributions: Double
                  )


sealed trait URL {
  def value: String
  def page: Int
}

case class RepositoriesURL(organization: String, page: Int) extends URL {
  override def value: String = s"https://api.github.com/orgs/$organization/repos?per_page=100&page=$page"
}

case class ContributorsURL(organization: String, repositoryName: String, page: Int) extends URL {
  override def value: String = s"https://api.github.com/repos/$organization/$repositoryName/contributors?per_page=100&page=$page"
}

